package inthebloodhorse.designpatter.memento;

// 备忘录类
public class EmpMemento {
    private String name;
    private Integer age;

    public EmpMemento(Emp emp) {
        this.name = emp.getName();
        this.age = emp.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
