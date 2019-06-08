package Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/6/6 15:54
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
    }


}
