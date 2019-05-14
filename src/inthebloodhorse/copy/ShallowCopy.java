package inthebloodhorse.copy;


class Teacher implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    private String name;
    private Double score;
    private Teacher teacher;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = null;
        p = (Person) super.clone();
        p.setTeacher((Teacher) getTeacher().clone());
        return p;
    }
}

public class ShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setName("yz");
        Person s1 = new Person();
        s1.setName("1ni");
        s1.setScore(55.5);
        s1.setTeacher(teacher);

        System.out.println("s1: " + s1.getName() + " " + s1.getScore());

        Person s2 = (Person) s1.clone();
        System.out.println("s2: " + s2.getName() + " " + s2.getScore());
        System.out.println("--------------------");
        s2.getTeacher().setName("新老师Tony");
        System.out.println("s1: " + s1.getName() + " " + s1.getTeacher().getName());
        System.out.println("s2: " + s2.getName() + " " + s2.getTeacher().getName());
    }
}
