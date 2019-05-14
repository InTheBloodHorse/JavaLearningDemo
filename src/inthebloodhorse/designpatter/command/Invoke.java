package inthebloodhorse.designpatter.command;

import java.util.ArrayList;
import java.util.List;

public class Invoke {
    private List<Command> commandList = new ArrayList<>();

    public Invoke() {
    }

    public void add(Command command) {
        commandList.add(command);
    }

    public void call() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
