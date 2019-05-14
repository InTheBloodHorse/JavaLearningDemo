package inthebloodhorse.designpatter.proxy.dynamicproxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        RealWorker realWorker = new RealWorker();
        WorkerHandler handler = new WorkerHandler(realWorker);
        // JDK自带动态代理
        Work work = (Work) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Work.class}, handler);
        Integer result = work.doWork(2);
        System.out.println(result);
    }
}
