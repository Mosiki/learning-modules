package pw.nullpointer.easypoi.entity.collection;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * @author WeJan
 * @since 2019-12-23
 */
@Data
public class EducationInputEntity {

    @Excel(name = "学校*")
    private String schoolName;

    @Excel(name = "学历*", replace = {"初中及以下_1", "中专_2", "高中_3", "大专_4", "本科_5", "硕士_6", "博士_7"})
    private String record;

    @Excel(name = "开始年份*")
    private Date beginTime;

    @Excel(name = "毕业年份*")
    private Date finishTime;

    @Excel(name = "专业*")
    private String profession;
}
