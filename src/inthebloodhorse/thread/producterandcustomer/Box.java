package inthebloodhorse.thread.producterandcustomer;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/7 15:56
 */
public class Box {
    private Integer apple = 0;
    private Integer MAX = 50;

    public Integer getApple() {
        return apple;
    }

    public synchronized Integer decrease(int number) {
        Boolean isAlive = Test.map.get("producer").isAlive();
        while (this.apple < number && isAlive) {
            try {
                System.out.printf("%d想要消费%d :在等待\n", Thread.activeCount(), number);
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.apple < number) {
            System.out.println("没的消费了");
            return this.apple ;
        }
        this.apple -= number;
        notify();
        return this.apple;
    }

    public synchronized Integer increase(int number) {
        Boolean isAlive = Test.map.get("customer").isAlive();
        while (this.apple + number > MAX && isAlive) {
            try {
                System.out.printf("%d想要生产%d :在等待\n", Thread.activeCount(), number);
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.apple + number > MAX) {
            System.out.println("不必再生产了！");
            return this.apple;
        }
        this.apple += number;
        notify();
        return this.apple;
    }

}
