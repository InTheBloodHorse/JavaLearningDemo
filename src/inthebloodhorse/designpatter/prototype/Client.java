package inthebloodhorse.designpatter.prototype;

import java.io.*;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CloneSheep cloneSheep = new CloneSheep();
        cloneSheep.setName("多利");
        cloneSheep.setDate(new Date());
        System.out.println(cloneSheep.getDate());
        // 序列化，反序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(cloneSheep);
        byte[] bytes = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        CloneSheep newSheep = (CloneSheep) ois.readObject();


        newSheep.setDate(new Date(newSheep.getDate().getTime() + 1000000));
        System.out.println(cloneSheep.getDate());
        System.out.println(newSheep.getDate());

    }
}
