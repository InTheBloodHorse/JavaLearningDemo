package inthebloodhorse.algorithm.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        p = new ListNode(list.get(0));
        head = p;
        for (int i = 1; i < list.size(); i++) {
            ListNode q = new ListNode(list.get(i));
            p.next = q;
            p = q;
        }
        return head;
    }
}
