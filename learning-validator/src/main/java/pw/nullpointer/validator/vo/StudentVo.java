package pw.nullpointer.validator.vo;

import lombok.Data;
import pw.nullpointer.validator.group.CreateGroup;
import pw.nullpointer.validator.group.UpdateGroup;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author WeJan
 * @since 2020-02-04
 */
@Data
public class StudentVo {

    @NotNull(groups = UpdateGroup.class, message = "学号不能为空")
    private Integer id;

    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull(groups = CreateGroup.class, message = "邮箱地址不能为空")
    @Email(groups = CreateGroup.class, message = "邮箱地址不正确")
    private String email;

    private Integer age;

}
