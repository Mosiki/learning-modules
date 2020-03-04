package pw.nullpointer.design.chainresponsibility.v1;

/**
 * 优惠券
 *
 * @author WeJan
 * @since 2020-02-11
 */
public class CouponOrderHandler extends AbstractHandler {

    @Override
    protected OrderHandleContext doHandle(OrderHandleContext context) {
        if (context.getCouponNo() != null) {
            context.setAmount(context.getAmount() - 10);
        }
        if (nextHandler != null) {
            return nextHandler.doHandle(context);
        } else {
            return context;
        }
    }
}
