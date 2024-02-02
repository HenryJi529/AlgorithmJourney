import java.util.Comparator;
import java.util.PriorityQueue;

import util.ListNode;

public class LeetCode23 {
    public static void main(String[] args) {
        ListNode[] list;
        // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
        // 输出：[1,1,2,3,4,4,5,6]
        list = new ListNode[] { ListNode.buildLinkedList(new Integer[] { 1, 4, 5 }),
                ListNode.buildLinkedList(new Integer[] { 1, 3, 4 }), ListNode.buildLinkedList(new Integer[] { 2, 6 }) };
        System.out.println(new Solution23().mergeKLists(list));

        // 输入：lists = []
        // 输出：[]
        list = new ListNode[] {};
        System.out.println(new Solution23().mergeKLists(list));

        // 输入：lists = [[]]
        // 输出：[]
        list = new ListNode[] { null };
        System.out.println(new Solution23().mergeKLists(list));
    }
}

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode currentNode = result;
        while (!queue.isEmpty()) {
            currentNode.next = queue.poll();
            if (currentNode.next.next != null) {
                queue.add(currentNode.next.next);
            }
            currentNode = currentNode.next;
        }

        return result.next;
    }
}