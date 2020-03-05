package pw.nullpointer.design.observer.eventbus;

import org.springframework.stereotype.Component;
import pw.nullpointer.design.observer.eventbus.common.AbstractProducer;

/**
 * @author WeJan
 * @since 2020-03-05
 */
@Component
public class UserRegisterProducer extends AbstractProducer<UserRegisterEvent> {

    @Override
    public void post(UserRegisterEvent event) {
        eventBus.post(event);
    }
}
