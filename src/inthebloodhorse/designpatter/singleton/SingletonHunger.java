package inthebloodhorse.designpatter.singleton;

/*
    单例模式
    饿汉式
    线程安全，调用效率高。不能延时加载
 */
public class SingletonHunger {
    // 类初始化时，立即加载这个对象
    private static SingletonHunger instance = new SingletonHunger();

    private SingletonHunger() {

    }

    // 方法没有同步(synchronized),效率高
    public static SingletonHunger getInstance() {
        return instance;
    }

}
