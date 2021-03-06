package inthebloodhorse.algorithm.array;


/*
    给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

    示例 1:

    输入: [2,3,-2,4]
    输出: 6
    解释: 子数组 [2,3] 有最大乘积 6。
    示例 2:

    输入: [-2,0,-1]
    输出: 0
    解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length + 5];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            ans = Math.max(dp[i], ans);
            for (int j = i + 1; j < nums.length; j++) {
                dp[j] = dp[j - 1] * nums[j];
                ans = Math.max(dp[j], ans);
            }
        }
        return ans;
    }

    public int maxProduct2(int[] nums) {
        int max = 1, min = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i] * max, nums[i]);
            min = Math.min(nums[i] * min, nums[i]);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
