package pw.nullpointer.mapstruct.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author WeJan
 * @since 2020-01-17
 */
@Data
@Accessors(chain = true)
public class User {
    private Long id;

    private String username;

    private String password;

    private Integer sex;

    private LocalDate birthday;

    private LocalDateTime createTime;

    private String config;

}
