package pw.nullpointer.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author WeJan
 * @since 2020-05-14
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Result<ExampleVO> test() {
        ExampleVO vo = new ExampleVO();
        vo.setDate(new Date());
        vo.setLocalDate(LocalDate.now());
        vo.setLocalDateTime(LocalDateTime.now());
        vo.setLocalTime(LocalTime.now());
        return Result.success(vo);
    }
}
