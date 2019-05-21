package inthebloodhorse.algorithm.stack;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case "+": {
                        stack.add(a + b);
                        break;
                    }
                    case "-": {
                        stack.add(b - a);
                        break;
                    }
                    case "*": {
                        stack.add(a * b);
                        break;
                    }
                    case "/": {
                        stack.add(b / a);
                        break;
                    }
                }
            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
