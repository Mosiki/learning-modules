package pw.nullpointer.design.chainresponsibility.v1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WeJan
 * @since 2020-02-11
 */
@Data
@AllArgsConstructor
public class OrderHandleContext {
    private String orderNo;

    private Double amount;

    private Integer vipLevel;

    private String couponNo;
}
