package inthebloodhorse.designpatter.proxy.staticproxy;

public class Worker implements Work {
    @Override
    public void doWork() {
        System.out.println("开始努力工作!!!");
    }
}
