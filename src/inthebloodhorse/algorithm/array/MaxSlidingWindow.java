package inthebloodhorse.algorithm.array;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSlidingWindow {
    int[] ans;
    Node[] vis;
    int index;
    int left, right;

    class Node {
        int val, id;

        public Node(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }


    private void add(Node node, int k) {
        while (right >= left && vis[right].val <= node.val) right--;
        vis[++right] = node;
        if (node.id < k - 1) return;
        while (vis[left].id <= node.id - k) {
            left++;
        }
        if (node.id < k - 1) return;
        ans[index++] = vis[left].val;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) k = 1;
        ans = new int[nums.length - (k - 1)];
        index = 0;
        vis = new Node[nums.length];
        left = 0;
        right = -1;
        for (int i = 0; i < nums.length; i++) {
            add(new Node(nums[i], i), k);
        }
        return ans;
    }

    public static void main(String[] args) {
        new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}