import util.ListNode;
import util.PrintUtil;

public class LeetCode83 {
    public static void main(String[] args) {
        // 输入：head = [1,1,2]
        // 输出：[1,2]
        System.out.println(new Solution83().deleteDuplicates(ListNode.buildLinkedList(new Integer[] { 1, 1, 2 })));
        PrintUtil.printDivider();

        // 输入：head = [1,1,2,3,3]
        // 输出：[1,2,3]
        System.out
                .println(new Solution83().deleteDuplicates(ListNode.buildLinkedList(new Integer[] { 1, 1, 2, 3, 3 })));
        PrintUtil.printDivider();

        // 输入：head = [1,1,1]
        // 输出：[1]
        System.out
                .println(new Solution83().deleteDuplicates(ListNode.buildLinkedList(new Integer[] { 1, 1, 1 })));
        PrintUtil.printDivider();
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
