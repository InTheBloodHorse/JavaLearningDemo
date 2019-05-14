package inthebloodhorse.enumtype;

public enum Operation {
    PLUS {
        @Override
        public Double operator(Double a, Double b) {
            return a + b;
        }
    }, SUB {
        @Override
        public Double operator(Double a, Double b) {
            return a - b;
        }
    }, MULTI {
        @Override
        public Double operator(Double a, Double b) {
            return a * b;
        }
    }, DIVIDE {
        @Override
        public Double operator(Double a, Double b) {
            return a / b;
        }
    };

    public abstract Double operator(Double a, Double b);
}

