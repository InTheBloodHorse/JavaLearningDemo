package inthebloodhorse.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak2 {
    private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    private void dfs(String str, List<String> temp, List<String> ans, List<String> wordDict) {
        if (str.length() == 0) {
            String[] array = temp.toArray(new String[0]);
            ans.add(String.join(" ", array));
            return;
        }
        for (int i = min; i <= Math.min(max, str.length()); i++) {
            String newStr = str.substring(0, i);
            if (wordDict.contains(newStr)) {
                temp.add(newStr);
                dfs(str.substring(i), new ArrayList<>(temp), ans, wordDict);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        for (String word : wordDict) {
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
        }
        if (wordBreak1(s, wordDict)) {
            dfs(s, new ArrayList<String>(), ans, wordDict);
        }
        return ans;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> list = new ArrayList<>(Arrays.asList(
                "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"
        ));
        System.out.println(new WordBreak2().wordBreak(s, list));
    }
}
