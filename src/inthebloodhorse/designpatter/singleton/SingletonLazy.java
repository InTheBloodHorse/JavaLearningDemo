package inthebloodhorse.designpatter.singleton;

/*
    单例模式
    懒汉式
    线程安全，调用效率不高。可以延时加载
 */
public class SingletonLazy {
    // 真正用到的时候才去加载
    private static SingletonLazy instance;

    private SingletonLazy() {

    }

    // 资源利用率高。调用getInstance方法都要同步，并发效率低
    public synchronized static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
