package pw.nullpointer.design.chainresponsibility;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 封装处理器链处理元素上下文
 *
 * @author WeJan
 * @since 2020-02-11
 */
@Data
@Accessors(chain = true)
public class OrderHandleContext {
    /**
     * 当前处理器位于处理器chain上的位置
     */
    private int pos;

    // 订单号
    private String orderNo;

    // 订单金额
    private Double amount;

    // VIP等级
    private Integer vipLevel;

    // 优惠券
    private String couponNo;
}
