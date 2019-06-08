package inthebloodhorse.thread.threadlocal;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/6 12:29
 */
public class SingletonBean {
    private static SingletonBean instance = new SingletonBean();
    //    private Integer a = 0;
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public Integer getThreadLocal() {
        return threadLocal.get();
//        return a;
    }

    public void setThreadLocal(Integer number) {
        threadLocal.set(getThreadLocal() + 1);
//        a++;
    }

    private SingletonBean() {
    }

    public static SingletonBean getInstance() {
        return instance;
    }
}
