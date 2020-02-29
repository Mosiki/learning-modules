package pw.nullpointer.design.state;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author WeJan
 * @since 2020-02-27
 */
@Data
@Accessors(chain = true)
public class Activity {
    private Long id;

    private String name;

    private Integer status;

    //... 省略其他字段

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
