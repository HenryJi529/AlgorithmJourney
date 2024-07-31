import util.ListNode;

public class LeetCode328 {
    public static void main(String[] args) {
        // 输入: head = [1,2,3,4,5]
        // 输出: [1,3,5,2,4]
        System.out.println(new Solution328().oddEvenList(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4, 5 })));

        // 输入: head = [2,1,3,5,6,4,7]
        // 输出: [2,3,6,7,1,5,4]
        System.out.println(
                new Solution328().oddEvenList(ListNode.buildLinkedList(new Integer[] { 2, 1, 3, 5, 6, 4, 7 })));
    }
}

class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddDummyNode = new ListNode();
        ListNode evenDummyNode = new ListNode();
        oddDummyNode.next = head;
        ListNode oddNode = head;
        ListNode evenNode = evenDummyNode;
        while (oddNode.next != null) {
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
            if (evenNode.next != null) {
                oddNode.next = evenNode.next;
                oddNode = oddNode.next;
            } else {
                break;
            }
        }
        if (oddNode.next == null) {
            evenNode.next = null;
        } else {
            oddNode.next = null;
        }
        oddNode.next = evenDummyNode.next;
        return oddDummyNode.next;
    }

}