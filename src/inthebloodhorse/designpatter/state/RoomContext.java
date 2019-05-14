package inthebloodhorse.designpatter.state;

public class RoomContext {
    private State state;

    public RoomContext() {
    }

    public void setState(State state) {
        this.state = state;
        showState();
    }

    public void showState() {
        this.state.handle();
    }


}
