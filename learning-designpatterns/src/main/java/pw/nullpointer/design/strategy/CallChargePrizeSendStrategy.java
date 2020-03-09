package pw.nullpointer.design.strategy;

import org.springframework.stereotype.Component;

/**
 * @author WeJan
 * @since 2020-02-06
 */
@Component
public class CallChargePrizeSendStrategy implements PrizeSendStrategy {
    @Override
    public String type() {
        return CALL_CHARGE;
    }

    @Override
    public void doSend() {
        System.out.println("发放话费奖品");
    }
}
