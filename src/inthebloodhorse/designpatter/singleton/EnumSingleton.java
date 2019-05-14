package inthebloodhorse.designpatter.singleton;

/*
    单例模式
    通过枚举来实现
    线程安全，调用效率高。不能延时加载
    因为枚举本身就是单例模式
    而且枚举可以阻止反射、序列化、反序列化漏洞，更加安全
 */
public enum EnumSingleton {
    // 枚举元素本身就是单例的
    INSTANCE;

    private Integer age = 1;

    // 添加自己需要的操作
    public void operation(Integer add) {
        age += add;
        System.out.println(age);
    }
}
