package inthebloodhorse.algorithm.linklist;


public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode ans = head;
        ListNode p = head, q;
        while (true) {
            q = p.next;
            if (q == null || q.next == null) {
                break;
            }
            p.next = q.next;
            q.next = q.next.next;
            ListNode temp = p.next;
            temp.next = q;
            p = p.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        new OddEvenList().oddEvenList(a1);
    }
}
