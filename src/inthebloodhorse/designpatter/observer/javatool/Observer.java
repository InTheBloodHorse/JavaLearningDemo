package inthebloodhorse.designpatter.observer.javatool;

import java.util.Observable;

public class Observer implements java.util.Observer {
    private Integer myState;

    @Override
    public void update(Observable o, Object arg) {
        this.myState = ((ConcreteSubject) o).getState();
    }

    public Integer getMyState() {
        return myState;
    }
}
