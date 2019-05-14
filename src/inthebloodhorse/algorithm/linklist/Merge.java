package inthebloodhorse.algorithm.linklist;

public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p = null;
        ListNode ans = null;
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if (list1.val < list2.val) {
            p = list1;
            list1 = list1.next;
        } else {
            p = list2;
            list2 = list2.next;
        }
        ans = p;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            while (list1 != null) {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            }
        } else {
            while (list2 != null) {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l3;
        l2.next = l4;
        System.out.println(new Merge().Merge(l1, l2));
    }
}
