package inthebloodhorse.thread.producterandcustomer.blockqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/7 18:48
 */
public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            int number = (int) (Math.random() * 1000);
            try {
                this.queue.put(number);
                System.out.println("添加成功:" + number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
