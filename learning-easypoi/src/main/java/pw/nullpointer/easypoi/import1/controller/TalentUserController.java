package pw.nullpointer.easypoi.import1.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.util.PoiValidationUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pw.nullpointer.easypoi.import1.entity.TalentUserInputEntity;
import pw.nullpointer.easypoi.import1.handler.TalentImportVerifyHandler;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author WeJan
 * @since 2019-12-23
 */
@RestController
@RequestMapping("/talentUser")
public class TalentUserController {

    @Resource
    private TalentImportVerifyHandler talentImportVerifyHandler;

    @PostMapping("/upload")
    public Boolean upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        ImportParams params = new ImportParams();
        // 表头设置为2行
        params.setHeadRows(2);
        // 标题行设置为0行，默认是0，可以不设置
        params.setTitleRows(0);
        // 开启Excel校验
        params.setNeedVerfiy(true);
        params.setVerifyHandler(talentImportVerifyHandler);
        ExcelImportResult<TalentUserInputEntity> result = ExcelImportUtil.importExcelMore(multipartFile.getInputStream(),
                TalentUserInputEntity.class, params);
        System.out.println("是否校验失败: " + result.isVerfiyFail());
        System.out.println("校验失败的集合:" + JSONObject.toJSONString(result.getFailList()));
        System.out.println("校验通过的集合:" + JSONObject.toJSONString(result.getList()));

        // 合并结果集
        List<TalentUserInputEntity> resultList = new ArrayList<>();
        resultList.addAll(result.getFailList());
        resultList.addAll(result.getList());
        for (TalentUserInputEntity inputEntity : resultList) {
            StringJoiner joiner = new StringJoiner(",");
            joiner.add(inputEntity.getErrorMsg());
            // 校验Collection的元素
            inputEntity.getExperienceList().forEach(e -> verify(joiner, e));
            inputEntity.getEducationList().forEach(e -> verify(joiner, e));
            inputEntity.getAwardList().forEach(e -> verify(joiner, e));
            inputEntity.getPunishmentList().forEach(e -> verify(joiner, e));
            inputEntity.setErrorMsg(joiner.toString());
        }

        for (TalentUserInputEntity entity : result.getFailList()) {
            int line = entity.getRowNum() + 1;
            String msg = "第" + line + "行的错误是：" + entity.getErrorMsg();
            System.out.println(msg);
        }
        return true;
    }

    private void verify(StringJoiner joiner, Object object) {
        String validationMsg = PoiValidationUtil.validation(object, null);
        if (StringUtils.isNotEmpty(validationMsg)) {
            joiner.add(validationMsg);
        }
    }
}
