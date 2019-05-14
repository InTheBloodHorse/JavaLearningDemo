package inthebloodhorse.designpatter.adapter;

public class Adapter implements Target {
    private Adaptee adaptee;

    @Override
    public void handleRequest() {
        adaptee.run();
    }

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
