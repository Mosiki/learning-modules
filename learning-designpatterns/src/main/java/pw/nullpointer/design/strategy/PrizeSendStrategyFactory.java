package pw.nullpointer.design.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WeJan
 * @since 2020-02-06
 */
public class PrizeSendStrategyFactory {
    private static final Map<String, PrizeSendStrategy> PRIZE_SEND_STRATEGY_MAP = new HashMap<>();

    static {
        PRIZE_SEND_STRATEGY_MAP.put(StrategyKeys.MONEY, new MoneyPrizeSendStrategy());
        PRIZE_SEND_STRATEGY_MAP.put(StrategyKeys.CALL_CHARGE, new CallChargePrizeSendStrategy());
        PRIZE_SEND_STRATEGY_MAP.put(StrategyKeys.IN_KIND, new InKindPrizeSendStrategy());
    }

    private PrizeSendStrategyFactory() {
    }

    private static final PrizeSendStrategy NONE_SEND_STRATEGY = new EmptyPrizeSendStrategy();

    public static PrizeSendStrategy getPrizeSendStrategy(String strategyKey) {
        return PRIZE_SEND_STRATEGY_MAP.getOrDefault(strategyKey, NONE_SEND_STRATEGY);
    }

    private interface StrategyKeys {
        String MONEY = "money";
        String IN_KIND = "in_kind";
        String CALL_CHARGE = "call_charge";
    }
}
