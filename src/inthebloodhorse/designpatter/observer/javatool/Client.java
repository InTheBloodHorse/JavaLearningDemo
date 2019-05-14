package inthebloodhorse.designpatter.observer.javatool;

public class Client {
    public static void main(String[] args) {
        // 目标对象
        ConcreteSubject concreteSubject = new ConcreteSubject();

        // 观察者对象
        Observer observerA1 = new Observer();
        Observer observerA2 = new Observer();
        Observer observerA3 = new Observer();

        // 添加对队列
        concreteSubject.addObserver(observerA1);
        concreteSubject.addObserver(observerA2);
        concreteSubject.addObserver(observerA3);

        // 更改状态
        concreteSubject.setState(30);

        // 查看观察者的状态
        System.out.println(observerA1.getMyState());
        System.out.println(observerA2.getMyState());
        System.out.println(observerA3.getMyState());

    }
}
