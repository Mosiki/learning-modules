package pw.nullpointer.easypoi.import1.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;
import pw.nullpointer.easypoi.import1.entity.collection.AwardsInputEntity;
import pw.nullpointer.easypoi.import1.entity.collection.EducationInputEntity;
import pw.nullpointer.easypoi.import1.entity.collection.ExperienceInputEntity;
import pw.nullpointer.easypoi.import1.entity.collection.PunishmentInputEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author WeJan
 * @since 2019-12-23
 */
@Data
public class TalentUserInputEntity implements IExcelDataModel, IExcelModel {
    // 时间格式校验正则
    public static final String DATE_REGEXP = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun)( )(Dec|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov)( )\\d{2}( )(00:00:00)( )(CST)( )\\d{4}";

    /**
     * 行号
     */
    private int rowNum;

    /**
     * 错误消息
     */
    private String errorMsg;

    @Excel(name = "姓名*")
    @NotBlank(message = "[姓名]不能为空")
    private String name;

    @Excel(name = "性别*", replace = {"男_0", "女_1"})
    @Pattern(regexp = "[01]", message = "性别错误")
    private String genderStr;

    @Excel(name = "手机号*")
    private String phone;

    @Excel(name = "开始工作时间*")
    @Pattern(regexp = DATE_REGEXP, message = "[开始工作时间]时间格式错误")
    private String workTimeStr;

    @Excel(name = "民族*")
    @NotBlank(message = "[民族]不能为空")
    private String national;

    @Excel(name = "语言水平*")
    @NotBlank(message = "[语言水平]不能为空")
    private String languageProficiency;

    @Excel(name = "出生日期*")
    @Pattern(regexp = DATE_REGEXP, message = "[出生日期]时间格式错误")
    private String birthStr;

    @Excel(name = "职位*")
    @NotBlank(message = "[职位]不能为空")
    private String jobsName;

    @Excel(name = "职位类型*")
    @NotBlank(message = "[职位类型]不能为空")
    private String categoryName;

    @Excel(name = "薪资*", replace = {"3K以下_1", "3K-5K_2", "5K-10K_3", "10K-20K_4", "20K-50K_5", "50K以上_6"})
    @Pattern(regexp = "[123456]", message = "薪资信息错误")
    private String salaryStr;

    @Excel(name = "工作地点*")
    @NotBlank(message = "[工作地点]不能为空")
    private String workArea;

    @ExcelCollection(name = "工作经历*")
    private List<ExperienceInputEntity> experienceList;

    @ExcelCollection(name = "教育经历*")
    private List<EducationInputEntity> educationList;

    @ExcelCollection(name = "获奖情况")
    private List<AwardsInputEntity> awardList;

    @ExcelCollection(name = "技能证书")
    private List<PunishmentInputEntity> punishmentList;

    @Excel(name = "特长")
    private String specialty;
}
