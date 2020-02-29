package pw.nullpointer.state;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pw.nullpointer.design.App;
import pw.nullpointer.design.state.*;

import java.time.LocalDateTime;

/**
 * @author WeJan
 * @since 2020-02-27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class BaseTest {


    @Test
    public void test1() {
        Activity activity = new Activity()
                .setId(1L)
                .setName("活动")
                .setStatus(ActivityStateEnum.DRAFT.getCode())
                .setCreateTime(LocalDateTime.now());

        ActivityState activityState = ActivityStateFactory.STATE_MAP.get(activity.getStatus());
        ActivityContext context = new ActivityContext();
        context.setActivityState(activityState);

        System.out.println("保存草稿: " + (context.saveDraft(activity) ? "成功" : "失败"));
        System.out.println("更新活动状态为已启用: " + (context.enable(activity) ? "成功" : "失败"));
        System.out.println("更新活动状态为进行中: " + (context.start(activity) ? "成功" : "失败"));
        System.out.println("更新活动状态为已停用: " + (context.disable(activity) ? "成功" : "失败"));
        System.out.println("更新活动状态为已启用: " + (context.enable(activity) ? "成功" : "失败"));
        System.out.println("更新活动状态为进行中: " + (context.start(activity) ? "成功" : "失败"));
        System.out.println("更新活动状态为已结束: " + (context.finish(activity) ? "成功" : "失败"));
        System.out.println("更新活动状态为进行中: " + (context.start(activity) ? "成功" : "失败"));
    }
}
