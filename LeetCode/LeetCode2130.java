import util.ListNode;

public class LeetCode2130 {
    public static void main(String[] args) {
        // 输入：head = [5,4,2,1]
        // 输出：6
        System.out.println(new Solution2130().pairSum(ListNode.buildLinkedList(new Integer[] { 5, 4, 2, 1 })));

        // 输入：head = [4,2,2,3]
        // 输出：7
        System.out.println(new Solution2130().pairSum(ListNode.buildLinkedList(new Integer[] { 4, 2, 2, 3 })));

        // 输入：head = [1,100000]
        // 输出：100001
        System.out.println(new Solution2130().pairSum(ListNode.buildLinkedList(new Integer[] { 1, 100000 })));
    }
}

/**
 * 先用快慢指针找到中间点，再用数组存储中间结果
 */
class Solution2130 {
    public int pairSum(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        int halfLen = 0;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            halfLen++;
        }
        int[] sum = new int[halfLen];

        ListNode p1 = dummyNode;
        ListNode p2 = slow;
        for (int i = 0; i < halfLen; i++) {
            p1 = p1.next;
            p2 = p2.next;
            sum[i] += p1.val;
            sum[halfLen - 1 - i] += p2.val;
        }

        int ans = sum[0];
        for (int i = 1; i < halfLen; i++) {
            ans = Math.max(sum[i], ans);
        }

        return ans;
    }
}