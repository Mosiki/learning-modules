package pw.nullpointer.redis.tools;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author WeJan
 * @since 2020-06-14
 */
@Component
public class RedisBlockQueue {

    @Resource
    private RedisConnectionFactory connectionFactory;

    public void lPush(@Nonnull String key, @Nonnull String value) {
        RedisConnection connection = RedisConnectionUtils.getConnection(connectionFactory);
        try {
            byte[] byteKey = RedisSerializer.string().serialize(getKey(key));
            byte[] byteValue = RedisSerializer.string().serialize(value);
            assert byteKey != null;
            connection.lPush(byteKey, byteValue);
        } finally {
            RedisConnectionUtils.releaseConnection(connection, connectionFactory);
        }
    }

    public void bRPopLPush(@Nonnull String key, Consumer<String> consumer) {
        CompletableFuture.runAsync(() -> {
            RedisConnection connection = RedisConnectionUtils.getConnection(connectionFactory);
            try {
                byte[] srcKey = RedisSerializer.string().serialize(getKey(key));
                byte[] dstKey = RedisSerializer.string().serialize(getBackupKey(key));
                assert srcKey != null;
                assert dstKey != null;
                while (true) {
                    byte[] byteValue = new byte[0];
                    boolean success = false;
                    try {
                        byteValue = connection.bRPopLPush(0, srcKey, dstKey);
                        if (byteValue != null && byteValue.length != 0) {
                            consumer.accept(new String(byteValue));
                            success = true;
                        }
                    } catch (Exception ignored) {
                        // 防止获取key达到超时时间抛出QueryTimeoutException异常退出
                        // 防止 Redis 连接失效，重新获取连接  https://github.com/Mosiki/learning-modules/issues/5
                        RedisConnectionUtils.releaseConnection(connection, connectionFactory);
                        connection = RedisConnectionUtils.getConnection(connectionFactory);
                    } finally {
                        if (success) {
                            // 处理成功才删除备份队列的key
                            connection.lRem(dstKey, 1, byteValue);
                        }
                    }
                }
            } finally {
                RedisConnectionUtils.releaseConnection(connection, connectionFactory);
            }
        });
    }

    private String getKey(String key) {
        return "queue:" + key;
    }

    private String getBackupKey(String key) {
        return "queue:" + key + ":bak";
    }

}
