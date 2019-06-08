package inthebloodhorse.thread.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/6 14:26
 */
public class Cache {
    private static Map<String, Entity> map = new HashMap<>();
    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public synchronized static void put(String key, Object data) {
        put(key, data, 0);
    }

    public synchronized static void put(String key, Object data, long expire) {
        // 清除原来的缓存
        remove(key);
        Future future = null;
        if (expire > 0) {
            future = executorService.schedule(() -> {
                synchronized (Cache.class) {
                    map.remove(key);
                }
            }, expire, TimeUnit.MILLISECONDS);
        }
        map.put(key, new Entity(data, future));
    }

    public synchronized static Object get(String key) {
        Entity entity = map.get(key);
        return entity == null ? null : entity.getValue();
    }

    public synchronized static <T> T get(String key, Class<T> tClass) {
        return tClass.cast(get(key));
    }

    public synchronized static Object remove(String key) {
        // 清除缓存数据
        Entity entity = map.remove(key);
        if (entity == null) {
            return null;
        }
        // 清除缓存定时器
        Future future = entity.getFuture();
        if (future != null) {
            future.cancel(true);
        }
        return entity.getValue();
    }

    public synchronized static int size() {
        return map.size();
    }

    private static class Entity {
        private Object value;
        // 定时器
        private Future future;

        public Entity(Object value, Future future) {
            this.value = value;
            this.future = future;
        }

        public Object getValue() {
            return value;
        }

        public Future getFuture() {
            return future;
        }
    }
}
