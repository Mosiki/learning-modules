package pw.nullpointer.design.strategy;

/**
 * @author WeJan
 * @since 2020-02-06
 */
public class CallChargePrizeSendStrategy implements PrizeSendStrategy {
    @Override
    public void doSend() {
        System.out.println("发放话费奖品");
    }
}
