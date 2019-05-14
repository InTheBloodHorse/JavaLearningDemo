package inthebloodhorse.designpatter.decorator;

public interface Car {
    void drive();
}


class MyCar implements Car {

    @Override
    public void drive() {
        System.out.println("陆地上行驶");
    }
}

class FlyCar implements Car {
    private Car car;

    public FlyCar(Car car) {
        this.car = car;
    }

    public void fly() {
        System.out.println("飞行");
    }

    @Override
    public void drive() {
        car.drive();
        fly();
    }
}

class AiCar implements Car {
    private Car car;

    public AiCar(Car car) {
        this.car = car;
    }

    public void auto() {
        System.out.println("自动驾驶");
    }

    @Override
    public void drive() {
        car.drive();
        auto();
    }
}
