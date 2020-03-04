package pw.nullpointer.design.chainresponsibility;

import org.springframework.stereotype.Component;

/**
 * 优惠券
 *
 * @author WeJan
 * @since 2020-02-11
 */
@Component
public class CouponOrderHandler extends AbstractHandler {

    @Override
    protected void doHandle(OrderHandleContext context, OrderHandlerChain chain) {
        if (context.getCouponNo() != null) {
            context.setAmount(context.getAmount() - 10);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    protected int weight() {
        return OrderHandlerWeightEnum.COUPON.getCode();
    }
}
