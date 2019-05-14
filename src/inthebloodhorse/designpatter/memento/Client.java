package inthebloodhorse.designpatter.memento;

public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Emp emp = new Emp("1ni", 21);
        System.out.println(emp);
        taker.setMemento(emp.memento()); // 进行一次备份

        emp.setAge(38);
        System.out.println(emp);

        emp.recover(taker.getMemento()); // 恢复
        System.out.println(emp);
    }
}
