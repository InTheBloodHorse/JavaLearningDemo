package inthebloodhorse.thread;


public class StopThread {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (flag) {
                i++;
                System.out.println(i);
            }
        });
        thread.start();
        Thread.sleep(1000);
        flag = false;
    }
}
