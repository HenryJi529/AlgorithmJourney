import util.ListNode;

public class LeetCode24 {
    public static void main(String[] args) {
        // 输入：head = [1,2,3,4]
        // 输出：[2,1,4,3]
        System.out.println(new Solution24().swapPairs(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4 })));

        // 输入：head = []
        // 输出：[]
        System.out.println(new Solution24().swapPairs(ListNode.buildLinkedList(new Integer[] {})));

        // 输入：head = [1]
        // 输出：[1]
        System.out.println(new Solution24().swapPairs(ListNode.buildLinkedList(new Integer[] { 1 })));
    }
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oldHead = head;
        ListNode newHead = head.next;

        oldHead.next = swapPairs(newHead.next);
        newHead.next = oldHead;

        return newHead;
    }
}