package inthebloodhorse.enumtype;

public class Test {
    public static void main(String[] args) {
        System.out.println(~10);
        System.out.println(Operation.PLUS.operator(1D, 2.6D));
        System.out.println(Operation.valueOf("DIVIDE").operator(5D, 3D));
        System.out.println(Operation.PLUS.ordinal());
        System.out.println(Operation.DIVIDE.ordinal());

    }
}

