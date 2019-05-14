package inthebloodhorse.designpatter.factory.simpleFactory;

public class Bmw implements Car {
    @Override
    public void drive() {
        System.out.println("Bmw is Running!");
    }
}
