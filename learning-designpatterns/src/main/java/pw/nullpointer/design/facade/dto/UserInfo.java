package pw.nullpointer.design.facade.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WeJan
 * @since 2020-03-03
 */
@Data
public class UserInfo {
    private Long id;
    private String username;
    private String email;
    private Integer age;
    private LocalDateTime createTime;
    private Integer status;
}
