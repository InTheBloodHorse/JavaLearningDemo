package inthebloodhorse.algorithm.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */
public class RandomizedSet {
    private Set<Integer> set;

    public RandomizedSet() {
        this.set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        Integer[] data = set.toArray(new Integer[]{0});
        int len = data.length;
        int index = (int) (Math.random() * len);
        return data[index];
    }
}
