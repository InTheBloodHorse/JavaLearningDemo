package inthebloodhorse.algorithm.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            int c = queue.poll();
            int d = queue.poll();
            if (a != b) {
                queue.add(a - b);
            }
        }
        if (queue.size() == 1) {
            return queue.peek();
        }
        return 0;
    }
}
