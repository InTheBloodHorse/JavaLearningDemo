package inthebloodhorse.designpatter;

class A {
    final static int a = 10;
    final static StringBuffer b = new StringBuffer("hEOOL");
}

public class Test {
    public static void main(String[] args) {
        System.out.println(A.a);
        System.out.println(A.b);
        A.b.append('c');
        System.out.println(A.b);
    }
}
