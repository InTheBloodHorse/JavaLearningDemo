package inthebloodhorse.designpatter.command;


public interface Command {
    void execute();
}

class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // 可以进行前置处理
        receiver.action();
        // 可以进行后续处理
    }
}
