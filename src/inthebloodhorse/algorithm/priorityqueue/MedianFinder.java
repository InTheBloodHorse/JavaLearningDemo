package inthebloodhorse.algorithm.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> minQ, maxQ;
    int sum = 0;

    public MedianFinder() {
        minQ = new PriorityQueue<>();
        maxQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int) (o2 - o1);
            }
        });
        sum = 0;
    }

    public void addNum(int num) {
        sum++;
        if (sum % 2 == 0) {
            if (!maxQ.isEmpty() && num < maxQ.peek()) {
                maxQ.add(num);
                num = maxQ.poll();
            }
            minQ.add(num);
        } else {
            if (!minQ.isEmpty() && num > minQ.peek()) {
                minQ.add(num);
                num = minQ.poll();
            }
            maxQ.add(num);
        }
    }

    public double findMedian() {
        if (maxQ.size() == minQ.size()) {
            return (maxQ.peek() + minQ.peek()) / 2.0;
        } else if (maxQ.size() > minQ.size()) {
            return maxQ.peek() * 1.0;
        } else {
            return minQ.peek() * 1.0;
        }
    }
}
