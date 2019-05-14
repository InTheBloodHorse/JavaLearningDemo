package inthebloodhorse.designpatter.templatemethod;

public class Client {
    public static void main(String[] args) {
        Eater eater = new Eater() {
            @Override
            void eat() {
                System.out.println("吃汉堡");
            }
        };

        eater.doProcess();
    }
}
