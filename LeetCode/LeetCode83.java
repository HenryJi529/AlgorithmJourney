/* 
 * 问题描述: https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */

import util.ListNode;

public class LeetCode83 {
    public static void main(String[] args) {

        ListNode head1 = new ListNode(1, null);
        head1.next = new ListNode(1, null);
        head1.next.next = new ListNode(2, null);
        System.out.println(head1);
        new Solution83().deleteDuplicates(head1);
        System.out.println(head1);
        System.out.println("================================================");

        ListNode head2 = new ListNode(1, null);
        head2.next = new ListNode(1, null);
        head2.next.next = new ListNode(2, null);
        head2.next.next.next = new ListNode(3, null);
        head2.next.next.next.next = new ListNode(3, null);
        System.out.println(head2);
        new Solution83().deleteDuplicates(head2);
        System.out.println(head2);
        System.out.println("================================================");

        ListNode head3 = new ListNode();
        System.out.println(head3);
        new Solution83().deleteDuplicates(head3);
        System.out.println(head3);
        System.out.println("================================================");

        ListNode head4 = new ListNode(1, null);
        head4.next = new ListNode(1, null);
        head4.next.next = new ListNode(1, null);
        System.out.println(head4);
        new Solution83().deleteDuplicates(head4);
        System.out.println(head4);
        System.out.println("================================================");
    }
}

class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.val == node.val) {
                if (node.next.next != null) {
                    node.next = node.next.next;
                } else {
                    node.next = null;
                    break;
                }
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
