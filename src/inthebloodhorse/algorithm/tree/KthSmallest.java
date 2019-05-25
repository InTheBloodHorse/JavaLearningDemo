package inthebloodhorse.algorithm.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 */
public class KthSmallest {

    int ans = 0;
    int len = 0;
    int k;

    private void dfs(TreeNode p) {
        if (p.left != null) {
            dfs(p.left);
        }
        if (len == k) {
            return;
        }
        ans = p.val;
        len++;
        if (p.right != null) {
            dfs(p.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }
}