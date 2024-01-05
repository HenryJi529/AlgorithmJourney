import util.ListNode;

public class LeetCode876 {
    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5]
        // 输出：[3,4,5]
        System.out.println(new Solution876().middleNode(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4, 5 })));

        // 输入：head = [1,2,3,4,5,6]
        // 输出：[4,5,6]
        System.out.println(new Solution876().middleNode(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4, 5, 6 })));
    }
}

class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }

        return slow;
    }
}