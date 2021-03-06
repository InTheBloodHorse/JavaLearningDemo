package inthebloodhorse.algorithm.array;

/*
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

    示例 1:

    输入: [1,2,3,4,5,6,7] 和 k = 3
    输出: [5,6,7,1,2,3,4]
    解释:
    向右旋转 1 步: [7,1,2,3,4,5,6]
    向右旋转 2 步: [6,7,1,2,3,4,5]
    向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] ans = new int[nums.length];
        int len = nums.length;
        int index = 0;
        for (int i = len - k; i < len; i++) {
            ans[index++] = nums[i];
        }
        for (int i = 0; i < len - k; i++) {
            ans[index++] = nums[i];
        }
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }


    public static void main(String[] args) {
        new Rotate().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
