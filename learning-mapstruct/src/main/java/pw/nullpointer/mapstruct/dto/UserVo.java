package pw.nullpointer.mapstruct.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

/**
 * @author WeJan
 * @since 2020-01-17
 */
@Data
@Accessors(chain = true)
public class UserVo {

    private Long id;

    private String username;

//    private String password;

    private Integer gender;

    private LocalDate birthday;

    private String createTime;

    private List<UserConfig> config;

    private String test;

    @Data
    public static class UserConfig {
        private String field1;
        private Integer field2;
    }
}
