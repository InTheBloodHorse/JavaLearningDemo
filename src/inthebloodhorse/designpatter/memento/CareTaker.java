package inthebloodhorse.designpatter.memento;

// 负责人类，管理备忘录对象
public class CareTaker {
    // 也可以是list
    private EmpMemento memento;

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
