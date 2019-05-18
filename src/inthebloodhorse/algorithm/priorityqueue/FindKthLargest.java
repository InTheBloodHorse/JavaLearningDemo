package inthebloodhorse.algorithm.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> number = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return -(o1 - o2);
                    }
                }
        );
        for (int i = 0; i < nums.length; i++) {
            number.add(nums[i]);
        }
        while (k-- > 1) {
            number.poll();
        }
        return number.poll();
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{1, 2, 3}, 1));
    }
}
