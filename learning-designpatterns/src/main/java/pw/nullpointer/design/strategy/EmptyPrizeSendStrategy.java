package pw.nullpointer.design.strategy;

import org.springframework.stereotype.Component;

/**
 * @author WeJan
 * @since 2020-02-06
 */
@Component
public class EmptyPrizeSendStrategy implements PrizeSendStrategy {
    @Override
    public String type() {
        return DEFAULT;
    }

    @Override
    public void doSend() {
        System.out.println("不发奖");
    }
}
