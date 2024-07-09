import util.ListNode;
import util.PrintUtil;

public class LeetCode21 {
    public static void main(String[] args) {
        // 输入：l1 = [1,2,4], l2 = [1,3,4]
        // 输出：[1,1,2,3,4,4]
        System.out.println(new Solution21().mergeTwoLists(ListNode.buildLinkedList(new Integer[] { 1, 2, 4 }),
                ListNode.buildLinkedList(new Integer[] { 1, 3, 4 })));
        PrintUtil.printDivider();

        // 输入：l1 = [], l2 = []
        // 输出：[]
        System.out.println(new Solution21().mergeTwoLists(ListNode.buildLinkedList(new Integer[] {}),
                ListNode.buildLinkedList(new Integer[] {})));
        PrintUtil.printDivider();

        // 输入：l1 = [], l2 = [0]
        // 输出：[0]
        System.out.println(new Solution21().mergeTwoLists(ListNode.buildLinkedList(new Integer[] {}),
                ListNode.buildLinkedList(new Integer[] { 0 })));
        PrintUtil.printDivider();
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