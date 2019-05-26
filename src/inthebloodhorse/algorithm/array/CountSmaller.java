package inthebloodhorse.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。
 * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class CountSmaller {
    List<Integer> data = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    private void bin(int target) {
        int left = 0;
        int right = data.size();
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (target <= data.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        ans.add(data.size() - right);
        data.add(left, target);
    }

    public List<Integer> countSmaller(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                ans.add(0);
                data.add(nums[i]);
            } else {
                bin(nums[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        new CountSmaller().countSmaller(new int[]{5, 2, 6, 1});
    }
}
