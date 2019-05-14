package inthebloodhorse.algorithm.linklist;

/*
    输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode ne = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            ne = temp;
            head = ne;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(new ReverseList().ReverseList(l1));
    }
}
