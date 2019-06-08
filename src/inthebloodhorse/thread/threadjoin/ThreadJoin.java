package inthebloodhorse.thread.threadjoin;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/6 9:51
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("睡");
                }
                System.out.println(1);
                System.out.println("释放锁");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(3);
            }
        });
        thread1.start();
        System.out.println("等待拿到锁");
        thread1.join();
        System.out.println("join结束");
        thread2.start();
        System.out.println(thread2.isAlive());
        thread2.join();
        thread3.start();
        thread3.join();
    }
}
