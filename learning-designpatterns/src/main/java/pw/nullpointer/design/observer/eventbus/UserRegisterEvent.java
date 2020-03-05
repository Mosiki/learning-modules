package pw.nullpointer.design.observer.eventbus;

import lombok.Data;

/**
 * @author WeJan
 * @since 2020-03-05
 */
@Data
public class UserRegisterEvent {
    private UserDto userDto;
}
