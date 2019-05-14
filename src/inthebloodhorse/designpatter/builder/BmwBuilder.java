package inthebloodhorse.designpatter.builder;

public class BmwBuilder extends CarBaseBuilder {
    @Override
    Engine buildEngine() {
        return new Engine("宝马发动机");
    }

    @Override
    Seat buildSeat() {
        return new Seat("宝马座位");
    }

    @Override
    Wheel buildWheel() {
        return new Wheel("宝马轮胎");
    }
}
