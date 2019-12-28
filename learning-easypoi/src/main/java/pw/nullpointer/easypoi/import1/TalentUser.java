package pw.nullpointer.easypoi.import1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WeJan
 * @since 2019-12-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentUser {
    private Long id;
    private String name;
    private String phone;
    // 省略其他字段
}
