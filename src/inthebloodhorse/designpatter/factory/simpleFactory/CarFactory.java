package inthebloodhorse.designpatter.factory.simpleFactory;

public class CarFactory {
    public static Car createCar(Integer type) {
        Class clazz = CarTypeMap.carType.get(type);
        try {
            return (Car) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
