package pw.nullpointer.design.strategy;

/**
 * @author WeJan
 * @since 2020-02-06
 */
public class PrizeSendContext {

    private PrizeSendStrategy prizeSendStrategy;

    public PrizeSendContext() {
    }

    public void setPrizeSendStrategy(PrizeSendStrategy prizeSendStrategy) {
        this.prizeSendStrategy = prizeSendStrategy;
    }

    public void executePrizeSendStrategy() {
        prizeSendStrategy.doSend();
    }
}
