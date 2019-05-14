package inthebloodhorse.designpatter.decorator;

public class Client {
    public static void main(String[] args) {
        MyCar car = new MyCar();
        // 在Car的基础上 加上 飞行
        FlyCar flyCar = new FlyCar(car);
        flyCar.drive();

        System.out.println("----------------");
        // 在FlyCar的基础上 加上 无人驾驶
        AiCar aiCar = new AiCar(flyCar);
        aiCar.drive();
    }
}
