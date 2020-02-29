package pw.nullpointer.design.state;

/**
 * @author WeJan
 * @since 2020-02-27
 */
public abstract class ActivityState {
    protected ActivityContext activityContext;

    public void setActivityContext(ActivityContext activityContext) {
        this.activityContext = activityContext;
    }

    public abstract Integer type();

    protected boolean isSameStatus(Activity activity) {
        return type().equals(activity.getStatus());
    }

    /**
     * 保存草稿
     *
     * @param activity
     */
    public abstract boolean saveDraft(Activity activity);

    /**
     * 启用
     *
     * @param activity
     */
    public abstract boolean enable(Activity activity);

    /**
     * 开始
     *
     * @param activity
     */
    public abstract boolean start(Activity activity);

    /**
     * 停用
     *
     * @param activity
     */
    public abstract boolean disable(Activity activity);

    /**
     * 停止
     *
     * @param activity
     */
    public abstract boolean finish(Activity activity);
}
