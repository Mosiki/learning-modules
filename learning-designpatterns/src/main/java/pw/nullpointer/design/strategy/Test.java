package pw.nullpointer.design.strategy;

/**
 * @author WeJan
 * @since 2020-02-06
 */
public class Test {
    public static void main(String[] args) {
        PrizeSendContext sendContext = new PrizeSendContext();
//        PrizeSendStrategy sendStrategy = new MoneyPrizeSendStrategy();
//        PrizeSendStrategy sendStrategy = new InKindPrizeSendStrategy();
//        PrizeSendStrategy sendStrategy = new CallChargePrizeSendStrategy();

        sendContext.setPrizeSendStrategy(PrizeSendStrategyFactory.getPrizeSendStrategy("money"));
        sendContext.executePrizeSendStrategy();
    }
}
