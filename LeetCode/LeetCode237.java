import util.ListNode;

public class LeetCode237 {
    public static void main(String[] args) {
        ListNode head, node;
        // 输入：head = [4,5,1,9], node = 5
        // 输出：[4,1,9]
        head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        node = head.next;
        new Solution237().deleteNode(node);
        System.out.println(head);

        // 输入：head = [4,5,1,9], node = 1
        // 输出：[4,5,9]
        head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        node = head.next.next;
        new Solution237().deleteNode(node);
        System.out.println(head);
    }
}

class Solution237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}