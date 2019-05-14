package inthebloodhorse.designpatter.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class WorkerHandler implements InvocationHandler {
    private Work worker;

    public WorkerHandler(Work worker) {
        this.worker = worker;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Long start = new Date().getTime();
        Object result = method.invoke(this.worker, args);
        Long end = new Date().getTime();
        System.out.println(String.format("耗时为:%d", end - start));
        return result;
    }
}
