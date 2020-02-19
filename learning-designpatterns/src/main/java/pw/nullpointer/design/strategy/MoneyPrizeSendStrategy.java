package pw.nullpointer.design.strategy;

/**
 * @author WeJan
 * @since 2020-02-06
 */
public class MoneyPrizeSendStrategy implements PrizeSendStrategy {
    @Override
    public void doSend() {
        System.out.println("发放现金奖品");
    }
}
