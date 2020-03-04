package pw.nullpointer.design.chainresponsibility.v1;

/**
 * 促销活动
 * @author WeJan
 * @since 2020-02-11
 */
public class SalesOrderHandler extends AbstractHandler{
    @Override
    protected OrderHandleContext doHandle(OrderHandleContext context) {
        Double amount = context.getAmount();
        if (amount > 80) {
            context.setAmount(amount * 0.9);
        }

        if (nextHandler != null) {
            return nextHandler.doHandle(context);
        } else {
            return context;
        }
    }
}
