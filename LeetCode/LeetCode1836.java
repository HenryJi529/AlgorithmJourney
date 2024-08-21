import java.util.HashMap;
import java.util.Map;

import util.ListNode;

public class LeetCode1836 {
    public static void main(String[] args) {
        // 输入: head = [1,2,3,2]
        // 输出: [1,3]
        System.out.println(
                new Solution1836().deleteDuplicatesUnsorted(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 2 })));
        System.out.println("================================================");

        // 输入: head = [2,1,1,2]
        // 输出: []
        System.out.println(
                new Solution1836().deleteDuplicatesUnsorted(ListNode.buildLinkedList(new Integer[] { 2, 1, 1, 2 })));
        System.out.println("================================================");

        // 输入: head = [3,2,2,1,3,2,4]
        // 输出: [1,4]
        System.out.println(
                new Solution1836()
                        .deleteDuplicatesUnsorted(ListNode.buildLinkedList(new Integer[] { 3, 2, 2,
                                1, 3, 2, 4 })));
        System.out.println("================================================");
    }
}

class Solution1836 {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        Map<Integer, Boolean> duplicated = new HashMap<>();
        ListNode pre = dummyNode;

        while (pre != null && pre.next != null) {
            if (duplicated.containsKey(pre.next.val)) {
                duplicated.put(pre.next.val, true);
                pre.next = pre.next.next;
            } else {
                duplicated.put(pre.next.val, false);
                pre = pre.next;
            }
        }

        pre = dummyNode;
        while (pre != null && pre.next != null) {
            if (duplicated.containsKey(pre.next.val) && duplicated.get(pre.next.val) == true) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return dummyNode.next;
    }
}