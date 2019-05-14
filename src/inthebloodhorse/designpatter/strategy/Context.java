package inthebloodhorse.designpatter.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }


    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void getPrice(Double price) {
        System.out.println("The price is : " + strategy.getPrice(price));
    }
}
