package inthebloodhorse.designpatter.proxy.staticproxy;

public class ProxyWorker implements Work {
    private Work realWorker;

    public ProxyWorker(Work realWorker) {
        this.realWorker = realWorker;
    }

    private void doWorkerBefore() {
        System.out.println("准备前置工作");
    }

    private void doWorkerAfter() {
        System.out.println("工作后续");
    }

    @Override
    public void doWork() {
        doWorkerBefore();
        this.realWorker.doWork();
        doWorkerAfter();
    }
}
