package inthebloodhorse.algorithm.linklist;


/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，
 * 时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd, even;
        ListNode p = head;
        ListNode q = head.next;
        odd = head;
        even = odd.next;
        while (even != null) {
            odd.next = even.next;
            if (odd.next == null) break;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = q;

        return p;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        new OddEvenList().oddEvenList(a1);
    }
}
