import java.util.PriorityQueue;
import java.util.Comparator;

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
    class ValueComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            return Integer.compare(n1.val, n2.val);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new ValueComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode currentNode = result;
        while (queue.size() > 0) {
            currentNode.next = queue.poll();
            if (currentNode.next.next != null) {
                queue.add(currentNode.next.next);
            }
            currentNode = currentNode.next;
        }

        return result.next;
    }
}