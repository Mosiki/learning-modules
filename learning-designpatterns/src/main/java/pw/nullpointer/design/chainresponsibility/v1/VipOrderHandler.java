package pw.nullpointer.design.chainresponsibility.v1;

/**
 * 会员权益
 *
 * @author WeJan
 * @since 2020-02-11
 */
public class VipOrderHandler extends AbstractHandler {
    @Override
    protected OrderHandleContext doHandle(OrderHandleContext context) {

        if (context.getVipLevel() > 2) {
            context.setAmount(context.getAmount() - 5);
        }
        if (nextHandler != null) {
            return nextHandler.doHandle(context);
        } else {
            return context;
        }
    }
}
