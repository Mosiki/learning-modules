package pw.nullpointer.observer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pw.nullpointer.design.observer.eventbus.UserDto;
import pw.nullpointer.design.observer.eventbus.UserRegisterEvent;
import pw.nullpointer.design.observer.eventbus.UserRegisterProducer;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author WeJan
 * @since 2020-03-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegisterProducerTest {

    @Resource
    private UserRegisterProducer userRegisterProducer;

    @Test
    public void post() {
        UserRegisterEvent event = new UserRegisterEvent();
        event.setUserDto(new UserDto(1L, "张三", LocalDateTime.now()));
        userRegisterProducer.post(event);
    }
}