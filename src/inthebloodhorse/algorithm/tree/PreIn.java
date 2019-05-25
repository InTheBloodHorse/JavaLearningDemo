package inthebloodhorse.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;

/*
    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
    则重建二叉树并返回。
 */
public class PreIn {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int total = pre.length;
        if (total == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int target = pre[0];
        int index = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == target) {
                index = i;
                break;
            }
        }
        int[] left_pre = new int[index];
        int[] left_in = new int[index];
        for (int i = 0; i < index; i++) {
            left_pre[i] = pre[i + 1];
            left_in[i] = in[i];
        }
        int[] right_pre = new int[total - index-1];
        int[] right_in = new int[total - index-1];
        for (int i = index + 1; i < total; i++) {
            right_pre[i - index - 1] = pre[i];
            right_in[i - index - 1] = in[i];
        }

        root.left = reConstructBinaryTree(left_pre, left_in);
        root.right = reConstructBinaryTree(right_pre, right_in);
        return root;
    }

    public static void main(String[] args) {
        PreIn preIn = new PreIn();
        preIn.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }
}

