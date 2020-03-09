package pw.nullpointer.design.strategy;

import org.springframework.stereotype.Component;

/**
 * @author WeJan
 * @since 2020-02-06
 */
@Component
public class MoneyPrizeSendStrategy implements PrizeSendStrategy {
    @Override
    public String type() {
        return MONEY;
    }

    @Override
    public void doSend() {
        System.out.println("发放现金奖品");
    }
}
