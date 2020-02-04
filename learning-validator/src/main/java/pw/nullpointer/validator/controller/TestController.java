package pw.nullpointer.validator.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pw.nullpointer.validator.group.CreateGroup;
import pw.nullpointer.validator.group.UpdateGroup;
import pw.nullpointer.validator.util.ValidatorUtils;
import pw.nullpointer.validator.vo.Result;
import pw.nullpointer.validator.vo.StudentVo;

/**
 * @author WeJan
 * @since 2020-02-04
 */
@RestController
public class TestController {

    @PostMapping("/create")
    public Result<StudentVo> create(@Validated(CreateGroup.class) StudentVo student) {
        System.out.println(student.toString());
        return Result.success(student);
    }

    @PostMapping("/update")
    public Result<StudentVo> update(@Validated(UpdateGroup.class) StudentVo student) {
        System.out.println(student.toString());
        return Result.success(student);
    }

    @PostMapping("/create2")
    public Result<StudentVo> create2(StudentVo student) {
        ValidatorUtils.validateEntity(student, CreateGroup.class);
        System.out.println(student.toString());
        return Result.success(student);
    }
}
