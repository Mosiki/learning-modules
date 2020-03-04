package pw.nullpointer.design.chainresponsibility;


/**
 * @author WeJan
 * @since 2020-02-11
 */
public abstract class AbstractHandler {
    protected abstract void doHandle(OrderHandleContext context, OrderHandlerChain chain);

    /**
     * 订单处理器的权重
     */
    protected abstract int weight();
}
