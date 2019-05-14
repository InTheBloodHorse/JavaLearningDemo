package inthebloodhorse.designpatter.singleton;

public class Test {
    public static void main(String[] args) {
//        EnumSingleton.INSTANCE.operation(1);
//        EnumSingleton.INSTANCE.operation(2);
//        EnumSingleton.INSTANCE.operation(3);
//        EnumSingleton.INSTANCE.operation(4);
//        EnumSingleton.INSTANCE.operation(5);
//        EnumSingleton.INSTANCE.operation(6);

        // 饿汉式
        SingletonHunger s1 = SingletonHunger.getInstance();
        SingletonHunger s2 = SingletonHunger.getInstance();
        System.out.println(s1 == s2);
//
//        // 懒汉式
//        SingletonLazy sl1 = SingletonLazy.getInstance();
//        SingletonLazy sl2 = SingletonLazy.getInstance();
//        System.out.println(sl1 == sl2);
//
//        DoubleCheckLock d1 = DoubleCheckLock.getInstance();
//        DoubleCheckLock d2 = DoubleCheckLock.getInstance();
//        System.out.println(d1 == d2);


    }
}
