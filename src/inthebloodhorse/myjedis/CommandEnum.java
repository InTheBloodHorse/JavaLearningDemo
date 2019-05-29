package inthebloodhorse.myjedis;

public enum CommandEnum {
    GET("GET"),
    SET("SET");
    private String command;

    CommandEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
