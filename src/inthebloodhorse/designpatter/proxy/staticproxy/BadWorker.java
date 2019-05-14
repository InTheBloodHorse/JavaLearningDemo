package inthebloodhorse.designpatter.proxy.staticproxy;

public class BadWorker implements Work {

    @Override
    public void doWork() {
        System.out.println("Work bad!!!");
    }
}
