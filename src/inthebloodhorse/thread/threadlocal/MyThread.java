package inthebloodhorse.thread.threadlocal;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/6 12:37
 */
public class MyThread implements Runnable {

    private SingletonBean singletonBean;

    public MyThread(SingletonBean singletonBean) {
        this.singletonBean = singletonBean;
    }

    public SingletonBean getSingletonBean() {
        return singletonBean;
    }

    public void setSingletonBean(SingletonBean singletonBean) {
        this.singletonBean = singletonBean;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            singletonBean.setThreadLocal(1);
        }
        System.out.println("自增结束" + singletonBean.getThreadLocal());
    }
}
