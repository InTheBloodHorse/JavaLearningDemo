package inthebloodhorse.designpatter.memento;

// 源发器
public class Emp {
    private String name;
    private Integer age;

    // 进行备忘操作，并返回备忘录对象
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    // 数据恢复
    public void recover(EmpMemento memento) {
        this.name = memento.getName();
        this.age = memento.getAge();
    }

    public Emp(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
