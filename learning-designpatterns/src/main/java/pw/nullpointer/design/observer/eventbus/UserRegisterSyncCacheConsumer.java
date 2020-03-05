package pw.nullpointer.design.observer.eventbus;

import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pw.nullpointer.design.observer.eventbus.common.EventConsumer;

import javax.annotation.Resource;

/**
 * @author WeJan
 * @since 2020-03-05
 */
@Component
public class UserRegisterSyncCacheConsumer implements EventConsumer<UserRegisterEvent>,
        InitializingBean {

    @Resource
    private UserRegisterProducer userRegisterProducer;

    @Override
    public void afterPropertiesSet() {
        userRegisterProducer.registerAsyncEvent(this);
    }

    @Override
    @Subscribe
    public void consume(UserRegisterEvent event) {
        System.out.println("接收到用户注册事件，开始同步Cache");
        System.out.println(event.getUserDto());
        System.out.println("接收到用户注册事件，同步Cache完毕");
    }
}
