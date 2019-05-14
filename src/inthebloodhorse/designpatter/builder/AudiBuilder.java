package inthebloodhorse.designpatter.builder;

public class AudiBuilder extends CarBaseBuilder {

    @Override
    public Engine buildEngine() {
        return new Engine("Audi牌发动机");
    }

    @Override
    public Seat buildSeat() {
        return new Seat("Audi牌座位");
    }

    @Override
    public Wheel buildWheel() {
        return new Wheel("Audi牌轮胎");
    }
}
