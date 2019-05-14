package inthebloodhorse.enumtype;

import java.util.function.DoubleBinaryOperator;

public enum OperationLambda {
    PLUS((x, y) -> x + y),
    SUB((x, y) -> x - y),
    MULTI((x, y) -> x * y),
    DIVIDE((x, y) -> x / y),
    ;
    // 代表枚举常量的行为
    private final DoubleBinaryOperator op;

    OperationLambda(DoubleBinaryOperator op) {
        this.op = op;
    }

    public Double operator(Double x, Double y) {
        return op.applyAsDouble(x, y);
    }


}
