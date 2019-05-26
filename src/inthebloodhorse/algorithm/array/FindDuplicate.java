package inthebloodhorse.algorithm.array;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int a = 0, b = 0;
        while (true) {
            a = nums[a];
            b = nums[nums[b]];
            if (a == b) {
                break;
            }
        }
        b = 0;
        while (true) {
            a = nums[a];
            b = nums[b];
            if (a == b) {
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{1, 3, 4, 2, 3}));
    }
}
