package inthebloodhorse.designpatter.strategy;

public class Client {
    public static void main(String[] args) {
        Strategy strategy = new BigDiscount();
        Strategy strategy1 = new LittleDiscount();
        Context context = new Context(strategy);
        context.getPrice(new Double(10));
        context.setStrategy(strategy1);
        context.getPrice(new Double(10));
    }
}
