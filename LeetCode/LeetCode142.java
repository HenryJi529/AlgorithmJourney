import util.ListNode;

public class LeetCode142 {
    public static void main(String[] args) {
        ListNode head;
        // 输入：head = [3,2,0,-4], pos = 1
        head = ListNode.buildLinkedList(new Integer[] { 3, 2, 0, -4 });
        head.next.next.next.next = head.next;
        ListNode.printNode(new Solution142().detectCycle(head));

        // 输入：head = [1,2], pos = 0
        head = ListNode.buildLinkedList(new Integer[] { 1, 2 });
        head.next.next = head;
        ListNode.printNode(new Solution142().detectCycle(head));

        // 输入：head = [1], pos = -1
        head = new ListNode(1);
        ListNode.printNode(new Solution142().detectCycle(head));
    }
}

class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
