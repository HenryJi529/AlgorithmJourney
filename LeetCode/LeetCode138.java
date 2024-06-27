import java.util.HashMap;

public class LeetCode138 {
    public static void main(String[] args) {
        // NOTE: 测试案例待补充
        System.out.println("Hello LeetCode138");
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node oldNode = head;
        Node newNode = newHead;
        while (oldNode.next != null) {
            if (!map.containsKey(oldNode.next)) {
                map.put(oldNode.next, new Node(oldNode.next.val));
            }

            if (oldNode.random != null && !map.containsKey(oldNode.random)) {
                map.put(oldNode.random, new Node(oldNode.random.val));
            }
            newNode.next = map.get(oldNode.next);
            newNode.random = map.get(oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        if (oldNode.random != null) {
            newNode.random = map.getOrDefault(oldNode.random, null);
        }
        return newHead;
    }
}