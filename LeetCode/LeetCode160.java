import util.ListNode;
import util.PrintUtil;

public class LeetCode160 {
    public static void main(String[] args) {
        ListNode headA;
        ListNode headB;
        ListNode headC;

        // 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2,
        // skipB = 3
        // 输出：Intersected at '8'
        headA = ListNode.buildLinkedList(new Integer[] { 4, 1 });
        headB = ListNode.buildLinkedList(new Integer[] { 5, 6, 1 });
        headC = ListNode.buildLinkedList(new Integer[] { 8, 4, 5 });
        headA.next.next = headC;
        headB.next.next.next = headC;
        // ListNode.printNode(new Solution160().getIntersectionNode(headA, headB));
        // PrintUtil.printDivider();

        // 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
        // 1
        // 输出：Intersected at '2'
        headA = ListNode.buildLinkedList(new Integer[] { 1, 9, 1 });
        headB = ListNode.buildLinkedList(new Integer[] { 3 });
        headC = ListNode.buildLinkedList(new Integer[] { 2, 4 });
        headA.next.next.next = headC;
        headB.next = headC;
        // ListNode.printNode(new Solution160().getIntersectionNode(headA, headB));
        // PrintUtil.printDivider();

        // 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
        // 输出：null
        headA = ListNode.buildLinkedList(new Integer[] { 2, 6, 4 });
        headB = ListNode.buildLinkedList(new Integer[] { 1, 5 });
        headC = ListNode.buildLinkedList(new Integer[] {});
        // ListNode.printNode(new Solution160().getIntersectionNode(headA, headB));
        // PrintUtil.printDivider();

        // 输入：intersectVal = 51, listA = [2,6,4,51], listB = [1,5,51], skipA = 3, skipB
        // = 51
        // 输出：51
        headA = ListNode.buildLinkedList(new Integer[] { 2, 6, 4 });
        headB = ListNode.buildLinkedList(new Integer[] { 1, 5 });
        headC = ListNode.buildLinkedList(new Integer[] { 51 });
        headA.next.next.next = headC;
        headB.next.next = headC;
        ListNode.printNode(new Solution160().getIntersectionNode(headA, headB));
        PrintUtil.printDivider();
    }
}

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = countLen(headA);
        int len2 = countLen(headB);
        // 缩短长的链
        if (len1 < len2) {
            // headB多遍历几个点
            int k = len2 - len1;
            while (k > 0) {
                headB = headB.next;
                k--;
            }
        } else if (len1 > len2) {
            // headA多遍历几个点
            int k = len1 - len2;
            while (k > 0) {
                headA = headA.next;
                k--;
            }
        }
        // 搜寻相同的点
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int countLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}