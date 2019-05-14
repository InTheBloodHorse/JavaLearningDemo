package inthebloodhorse.designpatter.command;

public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver("1ni");
        Command command = new ConcreteCommand(receiver);
        Receiver receiver1 = new Receiver("7in");
        Command command1 = new ConcreteCommand(receiver1);
        Invoke invoke = new Invoke();
        invoke.add(command);
        invoke.add(command1);

        invoke.call();

    }
}
