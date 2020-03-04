package pw.nullpointer.design.chainresponsibility;

import org.springframework.stereotype.Component;

/**
 * 会员权益
 *
 * @author WeJan
 * @since 2020-02-11
 */
@Component
public class VipOrderHandler extends AbstractHandler {
    @Override
    protected void doHandle(OrderHandleContext context, OrderHandlerChain chain) {
        if (context.getVipLevel() > 2) {
            context.setAmount(context.getAmount() - 5);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    protected int weight() {
        return OrderHandlerWeightEnum.VIP.getCode();
    }
}
