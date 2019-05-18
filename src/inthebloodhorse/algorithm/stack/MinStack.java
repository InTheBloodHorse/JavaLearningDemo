package inthebloodhorse.algorithm.stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    List<Integer> data;
    List<Integer> minData;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new ArrayList<>();
        minData = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
        if (minData.isEmpty()) {
            minData.add(x);
        } else {
            minData.add(Math.min(minData.get(minData.size() - 1), x));
        }
    }

    public void pop() {
        data.remove(data.size() - 1);
        minData.remove(minData.size() - 1);
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return minData.get(minData.size()-1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
