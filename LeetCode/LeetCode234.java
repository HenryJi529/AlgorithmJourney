import java.util.Deque;
import java.util.LinkedList;

import util.ListNode;

public class LeetCode234 {
    public static void main(String[] args) {
        // 输入：head = [1,2,2,1]
        // 输出：true
        System.out.println(new Solution234().isPalindrome(ListNode.buildLinkedList(new Integer[] { 1, 2, 2, 1 })));

        // 输入：head = [1,2]
        // 输出：false
        System.out.println(new Solution234().isPalindrome(ListNode.buildLinkedList(new Integer[] { 1, 2 })));

        // 输入：head = [1,2,3,2,1]
        // 输出：true
        System.out.println(new Solution234().isPalindrome(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 2, 1 })));
    }
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode slow = head;
        ListNode fast = head;
        stack.push(slow.val);

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }

        if (fast.next == null) {
            stack.pop();
        }

        ListNode tail = slow.next;
        while (tail != null) {
            if (stack.pop() != tail.val) {
                return false;
            }
            tail = tail.next;
        }
        return true;
    }
}