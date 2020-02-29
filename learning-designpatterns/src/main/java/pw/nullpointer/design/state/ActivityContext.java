package pw.nullpointer.design.state;

/**
 * @author WeJan
 * @since 2020-02-27
 */
public class ActivityContext {
    private ActivityState activityState;

    public void setActivityState(ActivityState activityState) {
        this.activityState = activityState;
        this.activityState.setActivityContext(this);
    }

    public boolean saveDraft(Activity activity) {
        return this.activityState.saveDraft(activity);
    }

    public boolean enable(Activity activity) {
        return this.activityState.enable(activity);
    }

    public boolean start(Activity activity) {
        return this.activityState.start(activity);
    }

    public boolean disable(Activity activity) {
        return this.activityState.disable(activity);
    }

    public boolean finish(Activity activity) {
        return this.activityState.finish(activity);
    }

}
