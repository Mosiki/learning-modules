package pw.nullpointer.redis.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pw.nullpointer.redis.RedisApplication;

import javax.annotation.Resource;
import java.util.concurrent.locks.LockSupport;

/**
 * @author WeJan
 * @since 2020-06-14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class RedisBlockQueueTest {
    @Resource
    private RedisBlockQueue redisBlockQueue;

    @Test
    public void testLPush() throws InterruptedException {
        String queueA = "queueA";
        int i = 0;
        while (true) {
            String msg = "Hello-" + i++;
            redisBlockQueue.lPush(queueA, msg);
            System.out.println("lPush: " + msg);
            Thread.sleep(3000);
        }
    }

    @Test
    public void testBRPopLPush() {
        String queueA = "queueA";
        redisBlockQueue.bRPopLPush(queueA, (val) -> {
            // 在这里处理具体的业务逻辑
            System.out.println("val: " + val);
        });

        // 防止Junit进程退出
        LockSupport.park();
    }
}