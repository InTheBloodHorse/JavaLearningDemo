package inthebloodhorse.algorithm.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        list.sort((o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });

        StringBuilder ans = new StringBuilder();
        for (String num : list) {
            ans.append(num);
        }
        if (ans.toString().replaceAll("0", "").equals("")) {
            return "0";
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        new LargestNumber().largestNumber(new int[]{121, 12});
    }
}