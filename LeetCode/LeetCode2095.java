import util.ListNode;

public class LeetCode2095 {
    public static void main(String[] args) {
        // 输入：head = [1,3,4,7,1,2,6]
        // 输出：[1,3,4,1,2,6]
        System.out.println(
                new Solution2095().deleteMiddle(ListNode.buildLinkedList(new Integer[] { 1, 3, 4, 7, 1, 2, 6 })));

        // 输入：head = [1,2,3,4]
        // 输出：[1,2,4]
        System.out.println(
                new Solution2095().deleteMiddle(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4 })));

        // 输入：head = [2,1]
        // 输出：[2]
        System.out.println(
                new Solution2095().deleteMiddle(ListNode.buildLinkedList(new Integer[] { 2, 1 })));
    }
}

class Solution2095 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next == null ? null : slow.next.next;

        return dummyNode.next;
    }
}