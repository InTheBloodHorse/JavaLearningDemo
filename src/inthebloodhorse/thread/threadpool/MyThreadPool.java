package inthebloodhorse.thread.threadpool;

import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.lang.Thread.State;

public class MyThreadPool {
    // 仓库
    private BlockingQueue<Runnable> blockingQueue;
    // 线程的集合
    private Vector<Thread> workers;

    private volatile boolean isWorking = true;

    private static class Worker extends Thread {
        private MyThreadPool pool;

        public Worker(MyThreadPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            // 持续拿任务
            // 2：关闭的时候，执行完未执行的任务
            while (pool.isWorking || pool.blockingQueue.size() > 0) {
                Runnable task = null;
                // 3：关闭的时候，不能阻塞的去拿任务
                try {
                    if (pool.isWorking) {
                        task = pool.blockingQueue.take();
                    } else {
                        task = pool.blockingQueue.poll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    task.run();
                    System.out.println(String.format("线程执行完毕:%s", Thread.currentThread().getName()));
                }
            }
        }
    }

    public MyThreadPool(int poolSize, int taskSize) {
        if (poolSize <= 0 || taskSize <= 0) {
            throw new IllegalArgumentException("参数不争取");
        }
        this.blockingQueue = new LinkedBlockingQueue<>(taskSize);
        this.workers = new Vector<>();
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }

    // 往仓库中放任务（非阻塞）
    public boolean submit(Runnable task) {
        // 1: 关闭的时候，仓库要停止有新的任务进来
        if (isWorking) {
            return blockingQueue.offer(task);
        }
        return false;
    }

    // 往仓库中放任务（阻塞）
    public void execute(Runnable task) {
        // 1: 关闭的时候，仓库要停止有新的任务进来
        if (isWorking) {
            try {
                blockingQueue.put(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Close
    /*
        1: 关闭的时候，仓库要停止有新的任务进来
        2：关闭的时候，执行完未执行的任务
        3：关闭的时候，不能阻塞的去拿任务
        4：关闭的时候，如果其他线程被阻塞，要强行中断
     */
    public void close() {
        isWorking = false;
        // 4：关闭的时候，如果其他线程被阻塞，要强行中断
        for (Thread thread : workers) {
            State state = thread.getState();
            if (State.WAITING.equals(state) || State.BLOCKED.equals(state)) {
                thread.interrupt();
            }
        }
    }
}
