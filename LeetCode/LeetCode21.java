/* 
 * 问题描述: https://leetcode.cn/problems/merge-two-sorted-lists/description/
 * 解题思路: 多指针迭代或递归
 */

import util.ListNode;

public class LeetCode21 {
    public static void main(String[] args) {
        ListNode l1, l2, l3;

        // 输入：l1 = [1,2,4], l2 = [1,3,4]
        // 输出：[1,1,2,3,4,4]
        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l3 = new Solution21().mergeTwoLists(l1, l2);
        System.out.println(l3);
        System.out.println("================================================");

        // 输入：l1 = [], l2 = []
        // 输出：[]
        l1 = new ListNode();
        l2 = new ListNode();
        l3 = new Solution21().mergeTwoLists(l1, l2);
        System.out.println(l3);
        System.out.println("================================================");

        // 输入：l1 = [], l2 = [0]
        // 输出：[0]
        l1 = new ListNode();
        l2 = new ListNode(0);
        l3 = new Solution21().mergeTwoLists(l1, l2);
        System.out.println(l3);
        System.out.println("================================================");
    }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode();

        ListNode currentListNode1 = list1;
        ListNode currentListNode2 = list2;
        ListNode currentListNode3 = list3;

        while (currentListNode1 != null || currentListNode2 != null) {
            if (currentListNode1 == null && currentListNode2 != null) {
                // currentListNode3.next = new ListNode(currentListNode2.val);
                currentListNode3.next = currentListNode2;
                currentListNode3 = currentListNode3.next;
                currentListNode2 = currentListNode2.next;
            } else if (currentListNode1 != null && currentListNode2 == null) {
                // currentListNode3.next = new ListNode(currentListNode1.val);
                currentListNode3.next = currentListNode1;
                currentListNode3 = currentListNode3.next;
                currentListNode1 = currentListNode1.next;
                continue;
            } else {
                if (currentListNode1.val < currentListNode2.val) {
                    // currentListNode3.next = new ListNode(currentListNode1.val);
                    currentListNode3.next = currentListNode1;
                    currentListNode1 = currentListNode1.next;
                } else {
                    // currentListNode3.next = new ListNode(currentListNode2.val);
                    currentListNode3.next = currentListNode2;
                    currentListNode2 = currentListNode2.next;
                }
                currentListNode3 = currentListNode3.next;
            }
        }
        return list3.next;
    }
}