package inthebloodhorse.thread.threadlocal;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/6 12:35
 */
public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread(SingletonBean.getInstance());
            Thread thread = new Thread(myThread);
            thread.start();
        }
    }
}
