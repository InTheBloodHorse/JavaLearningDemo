package inthebloodhorse.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargest {
    List<Integer> data = new ArrayList<>();

    private void merge(int k, int num) {
        if (data.isEmpty()) {
            data.add(num);
            return;
        }
        for (int i = data.size() - 1; i >= 0; i--) {
            if (data.get(i) > num) {
                data.add(i+1, num);
                if (data.size() == k + 1) {
                    data.remove(data.size() - 1);
                }
                return;
            }
        }
        data.add(0, num);
        if (data.size() == k + 1) {
            data.remove(data.size() - 1);
        }
    }

    public int findKthLargest(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            merge(k, nums[i]);
        }
        return data.get(data.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
