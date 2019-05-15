package inthebloodhorse.algorithm.bit;

/*
    给定一个double类型的浮点数base和int类型的整数exponent。
    求base的exponent次方。
 */
public class Power {
    public double pow(double base, int exponent) {
        double ans = 1F;
        if (exponent == 0) {
            return 1.0;
        }
        int flag = exponent > 0 ? 1 : 0;
        exponent = Math.abs(exponent);
        while (exponent > 0) {
            System.out.println(ans);
            if (exponent % 2 == 1) {
                ans *= base;
            }
            base *= base;

            exponent /= 2;
        }
        return flag == 1 ? ans : 1 / ans;
    }

    public double Power(double base, int exponent) {
        return pow(base, exponent);
    }

    public static void main(String[] args) {
        System.out.println(new Power().Power(2, -3));
    }
}
