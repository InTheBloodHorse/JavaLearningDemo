package inthebloodhorse.algorithm.array;

/*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        int[] fab = new int[50];
        fab[0] = 0;
        fab[1] = 1;
        fab[2] = 2;
        fab[3] = 3;
        for (int i = 4; i <= target; i++) {
            fab[i] = fab[i - 1] + fab[i - 2];
        }
        return fab[target];
    }
}
