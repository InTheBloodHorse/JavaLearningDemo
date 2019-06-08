package inthebloodhorse.thread.producterandcustomer;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/7 15:55
 */
public class Producer implements Runnable {

    private Box box;

    public Producer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int number = (int) (Math.random() * 10);
            product(number);
        }
    }

    public void product(int number) {
        int apple = box.increase(number);
        System.out.printf("生产了:%d,当前数量为:%d\n", number, apple);
    }

}
