package pw.nullpointer.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pw.nullpointer.design.App;
import pw.nullpointer.design.strategy.PrizeSendContext;
import pw.nullpointer.design.strategy.PrizeSendStrategyFactory;

/**
 * @author WeJan
 * @since 2020-02-06
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class StrategyTest {

    @Test
    public void test() {
        PrizeSendContext sendContext = new PrizeSendContext();
        sendContext.setPrizeSendStrategy(PrizeSendStrategyFactory.getPrizeSendStrategy("money"));
        sendContext.executePrizeSendStrategy();
    }

}
