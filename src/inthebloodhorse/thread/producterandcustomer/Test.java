package inthebloodhorse.thread.producterandcustomer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/7 16:04
 */
public class Test {
    public static Map<String, Thread> map = new HashMap<>();

    public static void main(String[] args) {
        Box box = new Box();
        Thread thread1 = new Thread(new Producer(box));
        thread1.setName("producer");
        Thread thread2 = new Thread(new Customer(box));
        thread2.setName("customer");
        map.put(thread1.getName(), thread1);
        map.put(thread2.getName(), thread2);
        thread1.start();
        thread2.start();
    }
}
