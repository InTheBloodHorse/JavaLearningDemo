package inthebloodhorse.designpatter.observer.my;

public interface Observer {
    void update(Subject subject);
}

class ObserverA implements Observer {

    private Integer myState; // 和目标对象的 state 保持一致

    @Override
    public void update(Subject subject) {
        this.myState = ((ConcreteSubject) subject).getState();
    }

    public Integer getMyState() {
        return myState;
    }
}