package inthebloodhorse.designpatter.proxy.staticproxy;


public class Client {
    public static void main(String[] args) {
        Work realWorker = new BadWorker();
        ProxyWorker proxyWorker = new ProxyWorker(realWorker);
        proxyWorker.doWork();
    }
}
