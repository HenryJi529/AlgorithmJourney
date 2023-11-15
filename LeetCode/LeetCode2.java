/* 
 * 问题描述: https://leetcode.cn/problems/add-two-numbers/
 */

import util.ListNode;

public class LeetCode2 {
    public static void main(String[] args) {
        ListNode head1, head2, head3;

        head1 = new ListNode(2, null);
        head1.next = new ListNode(3, null);
        head1.next.next = new ListNode(4, null);
        head2 = new ListNode(5, null);
        head2.next = new ListNode(6, null);
        head2.next.next = new ListNode(4, null);
        System.out.println(head1);
        System.out.println(head2);
        head3 = new Solution2().addTwoNumbers(head1, head2);
        System.out.println(head3);
        System.out.println("================================================");

        head1 = new ListNode(0, null);
        head2 = new ListNode(0, null);
        System.out.println(head1);
        System.out.println(head2);
        head3 = new Solution2().addTwoNumbers(head1, head2);
        System.out.println(head3);
        System.out.println("================================================");

        head1 = new ListNode(9, null);
        head1.next = new ListNode(9, null);
        head1.next.next = new ListNode(9, null);
        head1.next.next.next = new ListNode(9, null);
        head1.next.next.next.next = new ListNode(9, null);
        head1.next.next.next.next.next = new ListNode(9, null);
        head1.next.next.next.next.next.next = new ListNode(9, null);
        head2 = new ListNode(9, null);
        head2.next = new ListNode(9, null);
        head2.next.next = new ListNode(9, null);
        head2.next.next.next = new ListNode(9, null);
        System.out.println(head1);
        System.out.println(head2);
        head3 = new Solution2().addTwoNumbers(head1, head2);
        System.out.println(head3);
        System.out.println("================================================");
    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        ListNode currentNode3 = l3;
        int carry = 0;

        while (currentNode1 != null || currentNode2 != null || carry != 0) {
            if (currentNode1 == null && currentNode2 == null) {
                currentNode3.next = new ListNode(1);
                carry = 0;
            } else if (currentNode1 != null && currentNode2 == null) {
                currentNode3.next = new ListNode((currentNode1.val + carry) % 10);
                carry = (currentNode1.val + carry) / 10;
                currentNode1 = currentNode1.next;
            } else if (currentNode1 == null && currentNode2 != null) {
                currentNode3.next = new ListNode((currentNode2.val + carry) % 10);
                carry = (currentNode2.val + carry) / 10;
                currentNode2 = currentNode2.next;
            } else {
                currentNode3.next = new ListNode((currentNode1.val + currentNode2.val + carry) % 10);
                carry = (currentNode1.val + currentNode2.val + carry) / 10;
                currentNode1 = currentNode1.next;
                currentNode2 = currentNode2.next;
            }
            currentNode3 = currentNode3.next;
        }
        return l3.next;
    }
}