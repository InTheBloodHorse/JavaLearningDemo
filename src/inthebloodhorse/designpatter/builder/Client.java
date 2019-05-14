package inthebloodhorse.designpatter.builder;

public class Client {
    public static void main(String[] args) {
        CarDirectorImpl director = new CarDirectorImpl(new BmwBuilder());
        Car car = director.directorCar();
        System.out.println(car.getEngine().getName());
    }
}
