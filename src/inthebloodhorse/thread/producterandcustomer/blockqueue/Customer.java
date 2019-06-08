package inthebloodhorse.thread.producterandcustomer.blockqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/7 18:51
 */
public class Customer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Customer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10000; i++) {
            Integer result;
            try {
                result = this.queue.take();
                System.out.println("消费成功:" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
