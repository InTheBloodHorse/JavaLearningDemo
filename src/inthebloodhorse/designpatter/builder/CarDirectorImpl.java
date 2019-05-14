package inthebloodhorse.designpatter.builder;

public class CarDirectorImpl implements CarDirector {
    private CarBaseBuilder builder;

    public CarDirectorImpl(CarBaseBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Car directorCar() {
        Engine engine = builder.buildEngine();
        Seat seat = builder.buildSeat();
        Wheel wheel = builder.buildWheel();

        Car car = new Car(engine, seat, wheel);
        return car;
    }
}
