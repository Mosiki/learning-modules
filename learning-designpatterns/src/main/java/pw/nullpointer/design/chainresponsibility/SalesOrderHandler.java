package pw.nullpointer.design.chainresponsibility;

import org.springframework.stereotype.Component;

/**
 * 促销活动
 * @author WeJan
 * @since 2020-02-11
 */
@Component
public class SalesOrderHandler extends AbstractHandler {
    @Override
    protected void doHandle(OrderHandleContext context, OrderHandlerChain chain) {
        Double amount = context.getAmount();
        if (amount > 80) {
            context.setAmount(amount * 0.9);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    protected int weight() {
        return OrderHandlerWeightEnum.SALES.getCode();
    }
}
