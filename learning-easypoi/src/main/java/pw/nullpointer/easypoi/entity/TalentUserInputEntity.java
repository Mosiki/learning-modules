package pw.nullpointer.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.Data;
import pw.nullpointer.easypoi.entity.collection.AwardsInputEntity;
import pw.nullpointer.easypoi.entity.collection.EducationInputEntity;
import pw.nullpointer.easypoi.entity.collection.ExperienceInputEntity;
import pw.nullpointer.easypoi.entity.collection.PunishmentInputEntity;

import java.util.Date;
import java.util.List;

/**
 * @author WeJan
 * @since 2019-12-23
 */
@Data
public class TalentUserInputEntity {

    @Excel(name = "姓名*")
    private String name;

    @Excel(name = "性别*", replace = {"男_0", "女_1"})
    private Integer gender;

    @Excel(name = "手机号*")
    private String phone;

    @Excel(name = "开始工作时间*")
    private Date workTime;

    @Excel(name = "民族*")
    private String national;

    @Excel(name = "语言水平*")
    private String languageProficiency;

    @Excel(name = "出生日期*")
    private Date birth;

    @Excel(name = "职位*")
    private String jobsName;

    @Excel(name = "职位类型*")
    private String categoryName;

    @Excel(name = "薪资*", replace = {"3K以下_1", "3K-5K_2", "5K-10K_3", "10K-20K_4", "20K-50K_5", "50K以上_6"})
    private Integer salary;

    @Excel(name = "工作地点*")
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
