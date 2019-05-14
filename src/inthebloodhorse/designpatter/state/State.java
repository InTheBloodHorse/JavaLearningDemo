package inthebloodhorse.designpatter.state;

public interface State {
    void handle();

}

class FreeRoom implements State {

    @Override
    public void handle() {
        System.out.println("房间空闲");
    }

}

class OrderedRoom implements State {

    @Override
    public void handle() {
        System.out.println("房间已预定");
    }
}

class BusyRoom implements State {

    @Override
    public void handle() {
        System.out.println("房间已入住");
    }
}
