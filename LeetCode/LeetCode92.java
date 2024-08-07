import util.ListNode;
import util.PrintUtil;

public record LeetCode92() {
    public static void main(String[] args) {
        ListNode head;
        int left, right;
        // 输入：head = [1,2,3,4,5], left = 2, right = 4
        // 输出：[1,4,3,2,5]
        head = ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4, 5 });
        left = 2;
        right = 4;
        System.out.println(head + " left: " + left + " right: " + right);
        head = new Solution92().reverseBetween(head, left, right);
        System.out.println(head);
        PrintUtil.printDivider();

        // 输入：head = [5], left = 1, right = 1
        // 输出：[5]
        head = new ListNode(5);
        left = 1;
        right = 1;
        System.out.println(head + " left: " + left + " right: " + right);
        head = new Solution92().reverseBetween(head, left, right);
        System.out.println(head);
        PrintUtil.printDivider();

        // 输入：head = [3, 5], left = 1, right = 2
        // 输出：[5, 3]
        head = ListNode.buildLinkedList(new Integer[] { 3, 5 });
        left = 1;
        right = 2;
        System.out.println(head + " left: " + left + " right: " + right);
        head = new Solution92().reverseBetween(head, left, right);
        System.out.println(head);
        PrintUtil.printDivider();
    }
}

class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}