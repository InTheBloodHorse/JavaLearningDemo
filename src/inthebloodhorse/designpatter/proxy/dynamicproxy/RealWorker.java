package inthebloodhorse.designpatter.proxy.dynamicproxy;

public class RealWorker implements Work {

    @Override
    public Integer doWork(Integer type) {
        System.out.println("正在做工作:" + type);
        return type;
    }
}
