import util.ListNode;

public class LeetCode147 {
    public static void main(String[] args) {
        // 输入: head = [4,2,1,3]
        // 输出: [1,2,3,4]
        System.out.println(new Solution147().insertionSortList(ListNode.buildLinkedList(new Integer[] { 4, 2, 1, 3 })));

        // 输入: head = [-1,5,3,4,0]
        // 输出: [-1,0,3,4,5]
        System.out.println(
                new Solution147().insertionSortList(ListNode.buildLinkedList(new Integer[] {
                        -1, 5, 3, 4, 0 })));
    }
}

class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;

        ListNode sortedLastnode = head;
        ListNode unsortedFirstNode;
        while (sortedLastnode.next != null) {
            /* 对每个节点进行插入 */

            unsortedFirstNode = sortedLastnode.next;
            // System.out.println("当前排序: " + dummyNode);
            // System.out.println("处理节点" + unsortedFirstNode.val);
            // 将断连的节点插入已排序的链表
            ListNode currentNode = dummyNode;
            ListNode nextNode;
            while (currentNode != sortedLastnode) {
                nextNode = currentNode.next;
                // NOTE: 这里可以设置为pre和curr，更方便连接
                if (currentNode.val < sortedLastnode.next.val && currentNode.next.val >= sortedLastnode.next.val) {
                    // System.out.println("\t" + unsortedFirstNode.val + "插入" + node.val + "和" +
                    // node.next.val + "之间");
                    sortedLastnode.next = unsortedFirstNode.next;
                    currentNode.next = unsortedFirstNode;
                    unsortedFirstNode.next = nextNode;
                    break;
                }
                currentNode = currentNode.next;
            }
            if (currentNode == sortedLastnode) {
                sortedLastnode = sortedLastnode.next;
            }
        }

        return dummyNode.next;
    }
}