package pw.nullpointer.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pw.nullpointer.easypoi.entity.TalentUserInputEntity;

import java.util.List;

/**
 * @author WeJan
 * @since 2019-12-23
 */
@RestController
@RequestMapping("/talentUser")
public class TalentUserController {

    @PostMapping("/upload")
    public Boolean upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        ImportParams params = new ImportParams();
        // 表头设置为2行
        params.setHeadRows(2);
        // 标题行设置为0行，默认是0，可以不设置
        params.setTitleRows(0);
        List<TalentUserInputEntity> result = ExcelImportUtil.importExcel(multipartFile.getInputStream(),
                TalentUserInputEntity.class, params);
        System.out.println(JSONUtil.toJsonStr(result));
        return true;
    }
}
