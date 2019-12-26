package pw.nullpointer.easypoi.import1.entity.collection;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.Pattern;

import static pw.nullpointer.easypoi.import1.entity.TalentUserInputEntity.DATE_REGEXP;

@Data
public class PunishmentInputEntity {
    @Excel(name = "技能名称")
    private String description;

    @Excel(name = "获得时间")
    @Pattern(regexp = DATE_REGEXP, message = "[技能证书][获得时间]时间格式错误")
    private String dateStr;
}
