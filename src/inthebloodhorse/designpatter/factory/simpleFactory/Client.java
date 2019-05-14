package inthebloodhorse.designpatter.factory.simpleFactory;

public class Client {
    public static void main(String[] args) {
        Car car1 = CarFactory.createCar(2);
        Car car2 = CarFactory.createCar(2);
        Car car3 = CarFactory.createCar(1);
        car1.drive();
        car3.drive();

    }
}
