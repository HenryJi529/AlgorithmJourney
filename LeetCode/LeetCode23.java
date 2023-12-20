import java.util.PriorityQueue;
import java.util.Comparator;
import util.ListNode;

public class LeetCode23 {
    public static void main(String[] args) {
        ListNode[] list;
        ListNode n1, n2, n3;
        // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
        // 输出：[1,1,2,3,4,4,5,6]
        n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);
        n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);
        n3 = new ListNode(2);
        n3.next = new ListNode(6);
        list = new ListNode[] { n1, n2, n3 };
        System.out.println(new Solution23().mergeKLists(list));

        // 输入：lists = []
        // 输出：[]
        list = new ListNode[] {};
        System.out.println(new Solution23().mergeKLists(list));

        // 输入：lists = [[]]
        // 输出：[]
        n1 = null;
        list = new ListNode[] { n1 };
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
            // ListNode minListNode = queue.poll();
            // if (minListNode.next != null) {
            // queue.add(minListNode.next);
            // }
            // currentNode.next = minListNode;

            currentNode.next = queue.poll();
            if (currentNode.next.next != null) {
                queue.add(currentNode.next.next);
            }
            currentNode = currentNode.next;
        }

        return result.next;
    }
}