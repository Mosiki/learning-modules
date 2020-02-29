package pw.nullpointer.design.state;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author WeJan
 * @since 2020-02-27
 */
@Component
public class ActivityEnableState extends ActivityState {

    @Resource
    private ActivityDraftState activityDraftState;
    @Resource
    private ActivityStartState activityStartState;
    @Resource
    private ActivityDisableState activityDisableState;

    @Override
    public Integer type() {
        return ActivityStateEnum.ENABLE.getCode();
    }

    @Override
    public boolean saveDraft(Activity activity) {
        super.activityContext.setActivityState(activityDraftState);
        return activityContext.saveDraft(activity);
    }

    @Override
    public boolean enable(Activity activity) {
        if (isSameStatus(activity)) {
            return false;
        }
        activity.setStatus(type());
        //TODO 更新数据库
        return true;
    }

    @Override
    public boolean start(Activity activity) {
        super.activityContext.setActivityState(activityStartState);
        return activityContext.start(activity);
    }

    @Override
    public boolean disable(Activity activity) {
        super.activityContext.setActivityState(activityDisableState);
        return activityContext.disable(activity);
    }

    @Override
    public boolean finish(Activity activity) {
        return false;
    }
}
