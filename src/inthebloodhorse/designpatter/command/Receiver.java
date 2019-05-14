package inthebloodhorse.designpatter.command;

public class Receiver {
    private String name;

    public Receiver(String name) {
        this.name = name;
    }

    public void action() {
        System.out.println("调用action方法,Hello:" + this.name);
    }
}
