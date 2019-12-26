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
public class ExperienceInputEntity {
    @Excel(name = "公司名称*")
    private String companyName;

    @Excel(name = "所在行业*")
    private String industry;

    @Excel(name = "开始时间*")
    @Pattern(regexp = DATE_REGEXP, message = "[工作经历][开始时间]时间格式错误")
    private String beginTimeStr;

    @Excel(name = "结束时间*")
    @Pattern(regexp = DATE_REGEXP, message = "[工作经历][结束时间]时间格式错误")
    private String finishTimeStr;

    @Excel(name = "职位名称*")
    private String jobTitle;

    @Excel(name = "所属部门*")
    private String department;

    @Excel(name = "工作内容*")
    private String description;
}
