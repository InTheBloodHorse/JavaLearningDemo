package inthebloodhorse.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

    示例 1:

    输入: s = "anagram", t = "nagaram"
    输出: true
    示例 2:

    输入: s = "rat", t = "car"
    输出: false
*/

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i) - 'a', 1, (old, newValue) -> old + newValue);
        }
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i) - 'a', -1, (old, newValue) -> old + newValue);
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
