package inthebloodhorse.designpatter.builder;

abstract public class CarBaseBuilder {
    abstract Engine buildEngine();

    abstract Seat buildSeat();

    abstract Wheel buildWheel();
}
