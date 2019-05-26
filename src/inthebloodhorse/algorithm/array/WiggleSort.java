package inthebloodhorse.algorithm.array;

import java.util.Arrays;

/**
 * 给定一个无序的数组 nums，将它重新排列成
 * nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] ans = new int[len];
        int index = 0;
        int left = (len - 1) / 2;
        int right = len - 1;
        boolean flag = true;
        while (index < len) {
            if (flag) {
                ans[index++] = nums[left--];
            } else {
                ans[index++] = nums[right--];
            }
            flag = !flag;
        }
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        new WiggleSort().wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
    }
}
