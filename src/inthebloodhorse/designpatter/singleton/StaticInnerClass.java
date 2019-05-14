package inthebloodhorse.designpatter.singleton;

/*
    单例模式
    静态内部类
    线程安全，调用效率高。可以延时加载
    因为 类的加载过程是线程安全的
 */

public class StaticInnerClass {

    // 延迟加载 当调用了getInstance()方法的时候 再加载此内部类
    private static class InnerClass {
        private static StaticInnerClass instance = new StaticInnerClass();
    }

    private StaticInnerClass() {

    }

    public static StaticInnerClass getInstance() {
        return InnerClass.instance;
    }
}
