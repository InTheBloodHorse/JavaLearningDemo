package inthebloodhorse.algorithm.array;

public class Fibonacci {

    public int Fibonacci(int n) {
        int [] fab = new int[50];
        fab[0]=0;
        fab[1]=1;
        fab[2]=1;
        fab[3]=2;
        for(int i=4;i<=n;i++){
            fab[i] = fab[i-1]+fab[i-2];
        }
        return fab[n];
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().Fibonacci(39));
    }
}
