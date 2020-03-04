package pw.nullpointer.chain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pw.nullpointer.design.App;
import pw.nullpointer.design.chainresponsibility.OrderHandleContext;
import pw.nullpointer.design.chainresponsibility.OrderHandlerChain;

import javax.annotation.Resource;

/**
 * @author WeJan
 * @since 2020-03-03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ChainTest {

    @Resource
    private OrderHandlerChain orderHandlerChain;

    @Test
    public void name() {
        OrderHandleContext order = new OrderHandleContext()
                .setOrderNo("123")
                .setAmount(100d)
                .setVipLevel(3)
                .setCouponNo("111");
        orderHandlerChain.handle(order);
        System.out.println("订单最终金额为： " + order.getAmount());
    }
}
