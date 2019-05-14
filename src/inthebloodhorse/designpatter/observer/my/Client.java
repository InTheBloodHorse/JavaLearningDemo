package inthebloodhorse.designpatter.observer.my;

public class Client {
    public static void main(String[] args) {
        // 目标对象
        ConcreteSubject concreteSubject = new ConcreteSubject();

        // 观察者对象
        ObserverA observerA1 = new ObserverA();
        ObserverA observerA2 = new ObserverA();
        ObserverA observerA3 = new ObserverA();

        // 添加对队列
        concreteSubject.add(observerA1);
        concreteSubject.add(observerA2);
        concreteSubject.add(observerA3);

        // 更改状态
        concreteSubject.setState(30);

        // 查看观察者的状态
        System.out.println(observerA1.getMyState());
        System.out.println(observerA2.getMyState());
        System.out.println(observerA3.getMyState());
    }
}
