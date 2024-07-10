package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printNode(ListNode node) {
        System.out.println(node == null ? "null" : String.valueOf(node.val));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        sb.append("[");
        while (node != null) {
            sb.append(node.val);
            sb.append(", ");
            node = node.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static ListNode buildLinkedList(Integer[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nodes[0]);
        ListNode cur = head;
        int i = 1;
        while (i < nodes.length) {
            cur.next = new ListNode(nodes[i++]);
            cur = cur.next;
        }
        return head;
    }
}
