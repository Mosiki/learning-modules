package pw.nullpointer.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author WeJan
 * @since 2020-05-14
 */
@Data
public class ExampleVO {
    private LocalDateTime localDateTime;
    private LocalDate localDate;
    private Date date;
    private LocalTime localTime;
}
