package pw.nullpointer.design.state;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author WeJan
 * @since 2020-02-27
 */
@Component
public class ActivityDraftState extends ActivityState {
    @Resource
    private ActivityEnableState activityEnableState;

    @Override
    public Integer type() {
        return ActivityStateEnum.DRAFT.getCode();
    }

    @Override
    public boolean saveDraft(Activity activity) {
        // 更新
//        if (isSameStatus(activity)) {
//            return false;
//        }
        activity.setStatus(type());
        //TODO 更新数据库
        return true;
    }

    @Override
    public boolean enable(Activity activity) {
        super.activityContext.setActivityState(activityEnableState);
        return activityContext.enable(activity);
    }

    @Override
    public boolean start(Activity activity) {
        return false;
    }

    @Override
    public boolean disable(Activity activity) {
        return false;
    }

    @Override
    public boolean finish(Activity activity) {
        return false;
    }
}
