package inthebloodhorse.designpatter.state;

public class Client {
    public static void main(String[] args) {
        RoomContext context = new RoomContext();
        context.setState(new FreeRoom());
        context.setState(new BusyRoom());
        context.showState();
    }
}
