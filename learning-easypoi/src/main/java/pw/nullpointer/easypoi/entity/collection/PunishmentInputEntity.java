package pw.nullpointer.easypoi.entity.collection;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class PunishmentInputEntity {
    @Excel(name = "技能名称")
    private String description;

    @Excel(name = "获得时间")
    private Date date;
}
