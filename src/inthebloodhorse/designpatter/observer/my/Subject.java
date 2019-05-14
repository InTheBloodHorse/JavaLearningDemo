package inthebloodhorse.designpatter.observer.my;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    protected List<Observer> list = new ArrayList<>();

    public void add(Observer observer) {
        list.add(observer);
    }

    public void remove(Observer observer) {
        list.remove(observer);
    }

    // 通知所有观察者
    protected void notifyObserver() {
        for (Observer observer : list) {
            observer.update(this);
        }
    }

}

class ConcreteSubject extends Subject {
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
        // 通知所有观察者
        this.notifyObserver();
    }
}