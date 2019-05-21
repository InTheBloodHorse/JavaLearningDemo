package inthebloodhorse.algorithm.linklist;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();
        Node p = head;
        while (p != null) {
            Node node = new Node(p.val, null, null);
            map.put(p, node);
            p = p.next;
        }
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {

        Node a2 = new Node(2, null, null);
        Node a1 = new Node(1, a2, null);
        a1.next = a2;
        a1.random = a2;
        a2.next = null;
        a2.random = a2;
        new CopyRandomList().copyRandomList(a1);
    }
}
