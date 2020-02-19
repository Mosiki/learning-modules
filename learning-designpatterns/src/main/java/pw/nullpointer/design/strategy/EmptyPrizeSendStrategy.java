package pw.nullpointer.design.strategy;

/**
 * @author WeJan
 * @since 2020-02-06
 */
public class EmptyPrizeSendStrategy implements PrizeSendStrategy {
    @Override
    public void doSend() {
        System.out.println("不发奖");
    }
}
