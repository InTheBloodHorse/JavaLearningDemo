package inthebloodhorse.algorithm.array;

import java.util.concurrent.ThreadLocalRandom;

/*
    打乱一个没有重复元素的数组。

    示例:

    // 以数字集合 1, 2 和 3 初始化数组。
    int[] nums = {1,2,3};
    Solution solution = new Solution(nums);

    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
    solution.shuffle();

    // 重设数组到它的初始状态[1,2,3]。
    solution.reset();

    // 随机返回数组[1,2,3]打乱后的结果。
    solution.shuffle();
 */
public class Shuffle {
    private int[] nums;

    public Shuffle(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int len = nums.length;
        int[] array = new int[len];
        System.arraycopy(nums, 0, array, 0, nums.length);
        int index;
        for (int i = 0; i < len; i++) {
            index = ThreadLocalRandom.current().nextInt(len);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
