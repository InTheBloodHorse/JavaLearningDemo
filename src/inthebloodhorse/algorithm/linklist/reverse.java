package inthebloodhorse.algorithm.linklist;

import java.util.ArrayList;
import java.util.Collections;

public class reverse {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            while (listNode.next != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
            list.add(listNode.val);
        }
//        System.out.println(list);
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(67);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(24);
        ListNode listNode4 = new ListNode(58);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(reverse.printListFromTailToHead(listNode1));
    }
}
/*
    输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */


