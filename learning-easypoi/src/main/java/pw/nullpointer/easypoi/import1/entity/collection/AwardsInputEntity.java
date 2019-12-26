package pw.nullpointer.easypoi.import1.entity.collection;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.Pattern;

import static pw.nullpointer.easypoi.import1.entity.TalentUserInputEntity.DATE_REGEXP;

/**
 * @author WeJan
 * @since 2019-12-23
 */
@Data
public class AwardsInputEntity {

    @Excel(name = "奖项名称")
    private String name;

    @Excel(name = "说明")
    private String description;

    @Excel(name = "获奖时间")
    @Pattern(regexp = DATE_REGEXP, message = "[获奖经历][获奖时间]时间格式错误")
    private String dateStr;
}
