package pw.nullpointer.design.observer.eventbus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author WeJan
 * @since 2020-03-05
 */
@Data
@ToString
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private LocalDateTime registerTime;
}
