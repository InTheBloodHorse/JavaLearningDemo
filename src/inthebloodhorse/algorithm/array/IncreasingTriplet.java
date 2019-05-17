package inthebloodhorse.algorithm.array;

class Node {
    int val, num, pre;

    public Node(int val, int num, int pre) {
        this.val = val;
        this.num = num;
        this.pre = pre;
    }

}

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        Node[] dp = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            dp[i] = new Node(nums[i], 0, 0);
            for (int j = i - 1; j >= 0; j--) {
                if (number > dp[j].val) {
                    dp[j].pre = dp[j].val;
                    dp[j].val = number;
                    dp[j].num++;
                    if (dp[j].num == 2) {
                        return true;
                    }
                } else if (number < dp[j].val && number > dp[j].pre) {
                    dp[j].val = number;
                } else if (dp[j].num == 0) {
                    dp[j].val = Math.min(dp[j].val, number);
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num <= a){
                a = num;
            }else if(num<=b){
                b = num;
            }else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingTriplet().increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4}));
    }
}
