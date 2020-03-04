package pw.nullpointer.design.chainresponsibility.v1;

/**
 * @author WeJan
 * @since 2020-02-11
 */
public class Test {
    public static void main(String[] args) {
        AbstractHandler couponOrderHandler = new CouponOrderHandler();
        AbstractHandler vipOrderHandler = new VipOrderHandler();
        AbstractHandler salesOrderHandler = new SalesOrderHandler();
        couponOrderHandler.setNextHandler(salesOrderHandler);
        salesOrderHandler.setNextHandler(vipOrderHandler);

        OrderHandleContext order = new OrderHandleContext("123", 100D, 3, "111");
        OrderHandleContext result = couponOrderHandler.doHandle(order);
        System.out.println(result.getAmount());
    }
}
