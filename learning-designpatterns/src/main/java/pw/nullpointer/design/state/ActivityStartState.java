package pw.nullpointer.design.state;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author WeJan
 * @since 2020-02-27
 */
@Component
public class ActivityStartState extends ActivityState {

    @Resource
    private ActivityDisableState activityDisableState;
    @Resource
    private ActivityFinishState activityFinishState;

    @Override
    public Integer type() {
        return ActivityStateEnum.START.getCode();
    }

    @Override
    public boolean saveDraft(Activity activity) {
        return false;
    }

    @Override
    public boolean enable(Activity activity) {
        return false;
    }

    @Override
    public boolean start(Activity activity) {
        if (isSameStatus(activity)) {
            return false;
        }
        activity.setStatus(type());
        //TODO 更新数据库
        return true;
    }

    @Override
    public boolean disable(Activity activity) {
        super.activityContext.setActivityState(activityDisableState);
        return this.activityContext.disable(activity);
    }

    @Override
    public boolean finish(Activity activity) {
        super.activityContext.setActivityState(activityFinishState);
        return this.activityContext.finish(activity);
    }
}
