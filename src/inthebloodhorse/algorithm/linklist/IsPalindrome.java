package inthebloodhorse.algorithm.linklist;

/**
 * 请判断一个链表是否为回文链表。
 */
public class IsPalindrome {
    private ListNode reverseList(ListNode head, ListNode target) {
        ListNode pre = null;
        ListNode ne = null;
        while (head != target) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            ne = temp;
            head = ne;
        }
        return pre;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < len / 2 - 1; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        p = reverseList(head, q);
        if (len%2==1){
            q = q.next;
        }
        while (p.val == q.val) {
            p = p.next;
            q = q.next;
            if (p == null && q == null) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(1);
//        ListNode d = new ListNode(0);
        a.next = b;
        b.next = c;
//        c.next = d;
        new IsPalindrome().isPalindrome(a);
    }
}
