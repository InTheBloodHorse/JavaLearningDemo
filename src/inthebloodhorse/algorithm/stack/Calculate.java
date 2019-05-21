package inthebloodhorse.algorithm.stack;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 */
public class Calculate {
    private Stack<Integer> stack = new Stack<>();
    static int multOrDivde = -1;

    private void operator() {
        int a = stack.pop();
        int b = stack.pop();
        if (multOrDivde == 0) {
            stack.add(a * b);
        } else {
            stack.add(b / a);
        }
        multOrDivde = -1;
    }

    public int calculate(String s) {
        int temp = 0;
        boolean dis = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '+' || c == '-') {
                if (dis) {
                    temp = -temp;
                    dis = false;
                }
                stack.add(temp);
                if (multOrDivde != -1) operator();
                if (c == '-') {
                    dis = true;
                }
                temp = 0;
            } else if (c == '*' || c == '/') {
                stack.add(temp);
                if (multOrDivde != -1) operator();
                if (c == '*') multOrDivde = 0;
                if (c == '/') multOrDivde = 1;
                temp = 0;
            } else {
                temp = temp * 10 + (c - '0');
            }
        }
        if (dis) {
            temp = -temp;
        }
        stack.add(temp);
        if (multOrDivde != -1) operator();
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Calculate().calculate("3/2"));
    }
}
