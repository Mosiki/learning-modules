package pw.nullpointer.design.strategy;

/**
 * @author WeJan
 * @since 2020-02-06
 */
public interface PrizeSendStrategy {
    String DEFAULT = "default";
    String MONEY = "money";
    String IN_KIND = "in_kind";
    String CALL_CHARGE = "call_charge";

    String type();

    void doSend();
}
