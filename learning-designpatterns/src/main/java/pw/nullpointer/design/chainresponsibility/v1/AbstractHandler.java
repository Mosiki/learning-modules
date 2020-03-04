package pw.nullpointer.design.chainresponsibility.v1;

/**
 * @author WeJan
 * @since 2020-02-11
 */
public abstract class AbstractHandler {
    protected AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract OrderHandleContext doHandle(OrderHandleContext context);
}
