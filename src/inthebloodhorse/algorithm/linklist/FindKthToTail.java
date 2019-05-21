package inthebloodhorse.algorithm.linklist;

/*
    输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head;
        ListNode pre = head;
        int sum = 0;
        int a = k;
        while (p != null) {
            p = p.next;
            if (a < 1) {
                pre = pre.next;
            }
            a--;
            sum++;
        }
        return k<=sum ? pre : null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(new FindKthToTail().FindKthToTail(l1, 5));
    }
}

