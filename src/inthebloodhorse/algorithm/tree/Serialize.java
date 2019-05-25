package inthebloodhorse.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，
 * 采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */
public class Serialize {
    private void dfs(TreeNode root, List<String> data) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null) {
            data.add("null");
        } else {
            data.add(String.valueOf(left.val));
            dfs(left, data);
        }

        if (right == null) {
            data.add("null");
        } else {
            data.add(String.valueOf(right.val));
            dfs(right, data);
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> data = new ArrayList<>();
        data.add(String.valueOf(root.val));
        dfs(root, data);
        String ans = data.toString();
        return ans.substring(1, ans.length() - 1);
    }


    private TreeNode build(List<String> data) {
        if (data.size() == 0) {
            return null;
        }
        String front = data.get(0).trim();
        data.remove(0);
        if (front.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(front));
        node.left = build(data);
        node.right = build(data);
        return node;
    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] str = data.split(",");
        List<String> element = new ArrayList<>(Arrays.asList(str));
        return build(element);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        String data = new Serialize().serialize(t1);
        new Serialize().deserialize(data);
        System.out.println("".split(","));
    }
}
