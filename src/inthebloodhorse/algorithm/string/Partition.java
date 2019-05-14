package inthebloodhorse.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

    返回 s 所有可能的分割方案。
    输入: "aab"
    输出:
    [
      ["aa","b"],
      ["a","a","b"]
    ]
 */
public class Partition {
    public boolean isPar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public void dfs(String total, List<String> temp, List<List<String>> ans) {
        if (total.length() == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 1; i <= total.length(); i++) {
            String newStr = total.substring(0, i);
            if (isPar(newStr)) {
                temp.add(newStr);
                dfs(total.substring(i), temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(s, temp, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Partition().partition("aab"));
    }
}
