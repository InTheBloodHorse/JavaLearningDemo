package inthebloodhorse.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

    你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int number = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < number; i++) {
            map.merge(nums[i], 1, (old, newVal) -> old + newVal);
            if (map.get(nums[i]) > number / 2) {
//                System.out.println(nums[i]);
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new MajorityElement().majorityElement(new int[]{2,2,1,1,1,2,2});
    }
}
