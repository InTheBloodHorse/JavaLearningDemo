package inthebloodhorse.designpatter.adapter;

public class Client {
    public void test1(Target t) {
        t.handleRequest();
    }

    public static void main(String[] args) {
        Client client = new Client();

        Adaptee adaptee = new Adaptee();

        Adapter adapter = new Adapter(adaptee);

        client.test1(adapter);
    }
}
