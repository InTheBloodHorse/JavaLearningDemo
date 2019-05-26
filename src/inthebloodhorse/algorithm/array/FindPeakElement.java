package inthebloodhorse.algorithm.array;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int[] data = new int[nums.length + 2];
        System.arraycopy(nums, 0, data, 1, nums.length);
        data[0] = Integer.MIN_VALUE;
        data[nums.length+1] = Integer.MIN_VALUE;
        for (int i = 1; i < data.length - 1; i++) {
            if (data[i] > data[i - 1] && data[i] > data[i + 1]) {
                return i - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new FindPeakElement().findPeakElement(new int[]{1,2});
    }
}
