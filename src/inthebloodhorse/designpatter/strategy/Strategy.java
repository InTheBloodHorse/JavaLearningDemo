package inthebloodhorse.designpatter.strategy;

public interface Strategy {
    Double getPrice(Double price);
}

class BigDiscount implements Strategy {

    @Override
    public Double getPrice(Double price) {
        // 优惠力度很大
        return price * 0.5;
    }
}

class LittleDiscount implements Strategy {

    @Override
    public Double getPrice(Double price) {
        // 优惠力度很大
        return price * 0.9;
    }
}