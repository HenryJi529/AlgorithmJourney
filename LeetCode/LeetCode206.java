/*
 * 问题描述: https://leetcode.cn/problems/reverse-linked-list/
 * 解题思路: 递归(需要保证返回值为末端元素)
 */

import util.ListNode;

public class LeetCode206 {
    public static void main(String[] args) {
        ListNode head;
        // 输入：head = [1,2,3,4,5]
        // 输出：[5,4,3,2,1]
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        head = new Solution206().reverseList(head);
        System.out.println(head);
        System.out.println("================================================");

        // 输入：head = [1,2]
        // 输出：[2,1]
        head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(head);
        head = new Solution206().reverseList(head);
        System.out.println(head);
        System.out.println("================================================");

        // 输入：head = []
        // 输出：[]
        head = null;
        System.out.println(head);
        head = new Solution206().reverseList(head);
        System.out.println(head);
        System.out.println("================================================");
    }
}

class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = reverseList(head.next);
        // preNode 一直是最后一个元素
        head.next.next = head;
        head.next = null;
        return preNode;
    }
}