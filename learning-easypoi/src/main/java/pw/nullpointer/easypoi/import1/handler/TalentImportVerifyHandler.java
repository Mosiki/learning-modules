package pw.nullpointer.easypoi.import1.handler;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import org.springframework.stereotype.Component;
import pw.nullpointer.easypoi.import1.entity.TalentUserInputEntity;
import pw.nullpointer.easypoi.import1.service.MockTalentDataService;

import javax.annotation.Resource;
import java.util.StringJoiner;

/**
 * @author WeJan
 * @since 2019-12-28
 */
@Component
public class TalentImportVerifyHandler implements IExcelVerifyHandler<TalentUserInputEntity> {

    @Resource
    private MockTalentDataService mockTalentDataService;

    @Override
    public ExcelVerifyHandlerResult verifyHandler(TalentUserInputEntity inputEntity) {
        StringJoiner joiner = new StringJoiner(",");
        // 根据姓名与手机号判断数据是否重复
        String name = inputEntity.getName();
        String phone = inputEntity.getPhone();
        // mock 数据库
        boolean duplicates = mockTalentDataService.checkForDuplicates(name, phone);
        if (duplicates) {
            joiner.add("数据与数据库数据重复");
        }
        if (joiner.length() != 0) {
            return new ExcelVerifyHandlerResult(false, joiner.toString());
        }
        return new ExcelVerifyHandlerResult(true);
    }

}
