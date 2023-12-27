import util.ListNode;

public class LeetCode206 {
    public static void main(String[] args) {
        ListNode head;
        // 输入：head = [1,2,3,4,5]
        // 输出：[5,4,3,2,1]
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        head = new Solution206_3().reverseList(head);
        System.out.println(head);
        System.out.println("================================================");

        // 输入：head = [1,2]
        // 输出：[2,1]
        head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(head);
        head = new Solution206_3().reverseList(head);
        System.out.println(head);
        System.out.println("================================================");

        // 输入：head = []
        // 输出：[]
        head = null;
        System.out.println(head);
        head = new Solution206_3().reverseList(head);
        System.out.println(head);
        System.out.println("================================================");
    }
}

class Solution206_1 {
    // NOTE: 递归版本
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newFirstNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newFirstNode;
    }
}

class Solution206_2 {
    // NOTE: 迭代版本
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curNode = head;
        ListNode res = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = res;
            res = curNode;
            curNode = nextNode;
        }

        return res;
    }
}

class Solution206_3 {
    // NOTE: 迭代版本(更啰嗦)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curNode = head;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head.next;
        head.next = null;

        while (dummyNode.next.next != null) {
            ListNode tempNode = dummyNode.next.next;
            dummyNode.next.next = curNode;
            curNode = dummyNode.next;
            dummyNode.next = tempNode;
        }
        dummyNode.next.next = curNode;

        return dummyNode.next;
    }
}