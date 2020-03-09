package pw.nullpointer.design.strategy;

import org.springframework.stereotype.Component;

/**
 * @author WeJan
 * @since 2020-02-06
 */
@Component
public class InKindPrizeSendStrategy implements PrizeSendStrategy {
    @Override
    public String type() {
        return IN_KIND;
    }

    @Override
    public void doSend() {
        System.out.println("发放实物奖品");
    }
}
