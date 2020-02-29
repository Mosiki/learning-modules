package pw.nullpointer.design.state;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WeJan
 * @since 2020-02-29
 */
@Component
public class ActivityStateFactory implements ApplicationContextAware {
    public static final Map<Integer, ActivityState> STATE_MAP = new HashMap<>(ActivityStateEnum.values().length);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ActivityState> beans = applicationContext.getBeansOfType(ActivityState.class);
        beans.values().forEach(item -> STATE_MAP.put(item.type(), item));
    }
}
