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
public class UserRegisterNotifyConsumer implements EventConsumer<UserRegisterEvent>,
        InitializingBean {

    @Resource
    private UserRegisterProducer userRegisterProducer;

    @Override
    @Subscribe // 监听事件
    public void consume(UserRegisterEvent event) {
        System.out.println("接收到用户注册事件，开始推送通知");
        System.out.println(event);
        System.out.println("接收到用户注册事件，通知推送完毕");
    }

    @Override
    public void afterPropertiesSet() {
        userRegisterProducer.registerAsyncEvent(this);
    }
}
