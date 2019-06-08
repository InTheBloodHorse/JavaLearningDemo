package inthebloodhorse.thread.threadpool;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(3, 6);
        for (int i = 0; i < 10000000; i++) {
            final int a = i;
            Thread.sleep(10);
            pool.submit(() -> {
                System.out.println(String.format("任务进入队列:%d", a));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.close();
    }
}
