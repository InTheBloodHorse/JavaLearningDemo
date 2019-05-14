package inthebloodhorse.designpatter.observer.javatool;

import java.util.Observable;

public class ConcreteSubject extends Observable {
    private Integer state;

    public ConcreteSubject() {
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
        setChanged();
        notifyObservers(state);
    }
}
