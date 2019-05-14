package inthebloodhorse.algorithm.bit;

/*
    输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        char [] chars = Integer.toBinaryString(n).toCharArray();
        int ans=0;
        for (char c:chars){
            if (c=='1'){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new NumberOf1().NumberOf1(-3));
        System.out.println(new NumberOf1().NumberOf1(-1));
//        System.out.println(new NumberOf1().NumberOf1(-2));
    }
}
