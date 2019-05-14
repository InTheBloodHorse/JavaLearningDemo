package inthebloodhorse.designpatter.factory.simpleFactory;

public class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("Audi is runing!");
    }
}
