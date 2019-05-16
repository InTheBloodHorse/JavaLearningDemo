package inthebloodhorse.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i) - 'a', 1, (old, newValue) -> old + newValue);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i) - 'a') == 1) {
                return i;
            }
        }
        return -1;
    }
}
