package inthebloodhorse.algorithm.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    List<Integer> ans = new ArrayList<>();
    int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                ans.add(nested.getInteger());
            } else {
                dfs(nested.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return ans.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < ans.size();
    }

    public static void main(String[] args) {
        NestedIterator nestedIterator = new NestedIterator(null);
        while (nestedIterator.hasNext()) {

        }
    }
}