package inthebloodhorse.copy;

import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class ClassRoom implements Serializable {
    private static final long serialVersionUID = 1L;
    Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        // 写进流里
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        // 从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}

public class Copy2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassRoom classRoom1 = new ClassRoom();
        Student student = new Student();
        student.setName("123");
        classRoom1.setStudent(student);
        ClassRoom classRoom2 = (ClassRoom) classRoom1.deepClone();
        classRoom1.getStudent().setName("1ni");
        System.out.println("教室一的学生:" + classRoom1.getStudent().getName());
        System.out.println("教室二的学生:" + classRoom2.getStudent().getName());
    }
}
