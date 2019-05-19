package inthebloodhorse.algorithm.string;

import java.util.*;

public class LongestStrChain {
    public static int ans;
    public static Map<Integer, List<String>> map;
    public static Map<String, Integer> result;

    private void dfs(int len, String pre, int t) {
        int flag = 1;
        if (map.get(t + 1) == null) {
            ans = Math.max(ans, len);
            return;
        }
        for (String s : map.get(t + 1)) {
            if (judge(pre, s)) {
                dfs(len + 1, s, t + 1);
                flag = 0;
            }
        }
        if (flag == 1) {
            ans = Math.max(ans, len);
            return;
        }
    }

    private boolean judge(String pre, String target) {
        Map<Integer, Integer> element = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            element.merge((int) target.charAt(i), 1, (old, newV) -> old + newV);
        }
        for (int i = 0; i < pre.length(); i++) {
            element.merge((int) pre.charAt(i), -1, (old, newV) -> old + newV);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = element.entrySet().iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
                sum++;
            } else if (entry.getValue() != 0) {
                return false;
            }
        }
        return sum == 1;
    }

    public int longestStrChain(String[] words) {
        ans = 0;
        map = new HashMap<>();
        result = new HashMap<>();
        int maxn = 0;
        for (int i = 0; i < words.length; i++) {
            maxn = Math.max(maxn, words[i].length());
            map.merge(words[i].length(),
                    new ArrayList<>(Arrays.asList(words[i])),
                    (old, newV) -> {
                        old.add(newV.get(0));
                        return old;
                    });
        }
        Iterator<Map.Entry<Integer, List<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<String>> entry = iterator.next();
            if (maxn - entry.getKey() < ans) break;
            for (String s : entry.getValue()) {
                dfs(1, s, s.length());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestStrChain().longestStrChain(
                new String[]{
                        "kxbvnw", "uqjszp", "pmukt", "aai", "aaicwm", "mhkzelhyek", "cjv", "v", "uqjjspzpp", "aaim", "uqjjszp", "uqjjspzppd", "uqjjspzp", "aaicm", "pukt", "pvmukt", "dgdb", "aaicwbm", "mhkelhyek", "jv"
                }));
    }
}
