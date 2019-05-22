package inthebloodhorse.algorithm.linklist;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode p = node;
        while (p != null) {
            ListNode q = p.next;
            if (q == null) {
                break;
            }
            p.val = q.val;
            if (q.next == null) {
                p.next = null;
            }
            p = p.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        new DeleteNode().deleteNode(l2);
    }
}
