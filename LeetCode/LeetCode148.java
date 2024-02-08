import util.ListNode;

public class LeetCode148 {
    public static void main(String[] args) {
        // 输入：head = [4,2,1,3]
        // 输出：[1,2,3,4]
        System.out.println(new Solution148().sortList(ListNode.buildLinkedList(new Integer[] { 4, 2, 1, 3 })));

        // 输入：head = [-1,5,3,4,0]
        // 输出：[-1,0,3,4,5]
        System.out.println(new Solution148().sortList(ListNode.buildLinkedList(new Integer[] { -1, 5, 3, 4, 0 })));

        // 输入：head = []
        // 输出：[]
        System.out.println(new Solution148().sortList(ListNode.buildLinkedList(new Integer[] {})));
    }
}

class Solution148 {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        l1 = sort(l1);
        l2 = sort(l2);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dumNode = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode node = dumNode;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                node.next = p2;
                p2 = p2.next;
            } else if (p2 == null) {
                node.next = p1;
                p1 = p1.next;
            } else {
                if (p1.val <= p2.val) {
                    node.next = p1;
                    p1 = p1.next;
                } else {
                    node.next = p2;
                    p2 = p2.next;
                }
            }
            node = node.next;
        }
        return dumNode.next;
    }
}