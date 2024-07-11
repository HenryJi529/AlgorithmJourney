import java.util.ArrayList;
import java.util.List;

import util.ListNode;

public class LeetCode25 {
    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5], k = 2
        // 输出：[2,1,4,3,5]
        System.out
                .println(
                        new Solution25_1().reverseKGroup(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4, 5 }), 2));

        // 输入：head = [1,2,3,4,5], k = 3
        // 输出：[3,2,1,4,5]
        System.out
                .println(
                        new Solution25_1().reverseKGroup(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4, 5 }), 3));

        // 输入：head = [1,2,3,4], k = 2
        // 输出：[2,1,4,3]
        System.out
                .println(new Solution25_1().reverseKGroup(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4 }), 2));

        // 输入：head = [1,2,3,4], k = 1
        // 输出：[3,2,1,4]
        System.out
                .println(new Solution25_1().reverseKGroup(ListNode.buildLinkedList(new Integer[] { 1, 2, 3, 4 }), 1));
    }
}

/**
 * 先分段后翻转再拼接
 */
class Solution25_1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        List<ListNode[]> list = new ArrayList<>();
        ListNode start = head;
        ListNode end = head;
        int ind = 1;
        while (end.next != null) {
            end = end.next;
            ind++;
            if (ind == k) {
                list.add(new ListNode[] { start, end });
                // System.out.println(start.val + " " + end.val);
                if (end.next == null) {
                    start = null;
                    break;
                } else {
                    // 切断每节的末尾与下一节的连接
                    ListNode temp = end;
                    end = end.next;
                    start = end;
                    temp.next = null;
                    // 开始新的一节
                    ind = 1;
                }
            }
        }
        for (ListNode[] interval : list) {
            reverse(interval[0]);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i)[0].next = list.get(i + 1)[1];
        }
        list.getLast()[0].next = start;
        return list.size() == 0 ? head : list.get(0)[1];
    }

    public void reverse(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        reverse(head.next);
        head.next.next = head;
        head.next = null;
        return;
    }
}

/**
 * 分段时直接翻转并借助dummyNode获取最后的head
 */
class Solution25_2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[] { tail, head };
    }
}
