package Test;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/6 16:43
 */

class Person implements Cloneable {
    public int a;

    public Person(int a) {
        this.a = a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person;
        person = (Person) super.clone();
        return person;
    }
}

public class TestArrayCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
//        Person[] p1 = new Person[]{new Person(1), new Person(2), new Person(3)};
//        Person[] p2 = p1;
//
//        for (int i = 0; i < p1.length; i++) {
//            p2[i] = (Person) p1[i].clone();
//        }
//        System.out.println(p1[0].a);
        int num = 0;
        num++;
        System.out.println(num);
    }
}
