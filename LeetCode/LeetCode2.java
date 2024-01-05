import util.ListNode;

public class LeetCode2 {
    public static void main(String[] args) {
        // 输入：l1 = [2,4,3], l2 = [5,6,4]
        // 输出：[7,0,8]
        // 解释：342 + 465 = 807.
        System.out.println(new Solution2().addTwoNumbers(ListNode.buildLinkedList(new Integer[] { 2, 4, 3 }),
                ListNode.buildLinkedList(new Integer[] { 5, 6, 4 })));
        System.out.println("================================================");

        // 输入：l1 = [0], l2 = [0]
        // 输出：[0]
        System.out.println(new Solution2().addTwoNumbers(ListNode.buildLinkedList(new Integer[] { 0 }),
                ListNode.buildLinkedList(new Integer[] { 0 })));
        System.out.println("================================================");

        // 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        // 输出：[8,9,9,9,0,0,0,1]
        System.out
                .println(new Solution2().addTwoNumbers(ListNode.buildLinkedList(new Integer[] { 9, 9, 9, 9, 9, 9, 9 }),
                        ListNode.buildLinkedList(new Integer[] { 9, 9, 9, 9 })));
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