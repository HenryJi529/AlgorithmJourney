import util.ListNode;

public class LeetCode19 {
    public static void main(String[] args) {
        ListNode head;
        // 输入：head = [1,2,3,4,5], n = 2
        // 输出：[1,2,3,5]
        head = ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4, 5 });
        System.out.println(head);
        head = new Solution19().removeNthFromEnd(head, 2);
        System.out.println(head);
        System.out.println("================================================");

        // 输入：head = [1], n = 1
        // 输出：[]
        head = new ListNode(1);
        System.out.println(head);
        head = new Solution19().removeNthFromEnd(head, 1);
        System.out.println(head);
        System.out.println("================================================");

        // 输入：head = [1,2], n = 1
        // 输出：[1]
        head = ListNode.buildLinkedList(new Integer[] { 1, 2 });
        System.out.println(head);
        head = new Solution19().removeNthFromEnd(head, 1);
        System.out.println(head);
        System.out.println("================================================");

        // 输入：head = [1,2], n = 2
        // 输出：[2]
        head = ListNode.buildLinkedList(new Integer[] { 1, 2 });
        System.out.println(head);
        head = new Solution19().removeNthFromEnd(head, 2);
        System.out.println(head);
        System.out.println("================================================");
    }
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            head = head.next;
            return head;
        }

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }
}