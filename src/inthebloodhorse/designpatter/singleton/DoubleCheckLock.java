package inthebloodhorse.designpatter.singleton;

/*
    单例模式
    双重检测锁实现
    这个模式将同步内容下放到if内部，提高执行效率
    不必每次获取对象时都进行同步，只有第一次才同步
    创建了以后就没必要了
 */

public class DoubleCheckLock {
    private static DoubleCheckLock instance;

    private DoubleCheckLock() {

    }

    public static DoubleCheckLock getInstance() {
        if (instance == null) {
            DoubleCheckLock temp;
            synchronized (DoubleCheckLock.class) {
                temp = instance;
                if (temp == null) {
                    synchronized (DoubleCheckLock.class) {
                        if (temp == null) {
                            temp = new DoubleCheckLock();
                        }
                    }
                    instance = temp;
                }
            }
        }
        return instance;
    }
}
