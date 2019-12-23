package pw.nullpointer.easypoi.entity.collection;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

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
    private Date date;
}
