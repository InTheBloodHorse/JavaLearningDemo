package inthebloodhorse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void addToList(Object val, List target) {
        target.add(val);
    }

    public static void main(String[] args) {
        List<Integer> l1 = TestCollection.getEmptyList();

        l1.add(1);
        System.out.println(l1);
        System.out.println(TestCollection.getEmptyList());
    }
}

class TestCollection {
    private static final Integer[] array = new Integer[0];

    public static List<Integer> getEmptyList() {
        System.out.println(Arrays.asList(array).getClass());

        return new ArrayList<>(Arrays.asList(array));
    }

}
