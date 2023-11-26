import util.ListNode;

public class LeetCode141 {
    public static void main(String[] args) {
        ListNode head;
        // 输入：head = [3,2,0,-4], pos = 1
        // 输出：true
        head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(new Solution141().hasCycle(head));

        // 输入：head = [1,2], pos = 0
        // 输出：true
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(new Solution141().hasCycle(head));

        // 输入：head = [1], pos = -1
        // 输出：false
        head = new ListNode(1);
        System.out.println(new Solution141().hasCycle(head));
    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && slow.next != null && fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}