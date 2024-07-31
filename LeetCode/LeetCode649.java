import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode649 {
    public static void main(String[] args) {
        // 输入：senate = "RD"
        // 输出："Radiant"
        System.out.println(new Solution649_2().predictPartyVictory("RD"));

        // 输入：senate = "RDD"
        // 输出："Dire"
        System.out.println(new Solution649_2().predictPartyVictory("RDD"));
    }
}

/**
 * 构造一个环，遍历每个节点的时删除敌对的下一个节点直到只剩一种节点
 */
class Solution649_1 {
    class Node {
        char val;
        Node next;

        Node() {
        }

        Node(char value) {
            this.val = value;
        }
    }

    public String predictPartyVictory(String senate) {
        int countR = 0;
        int countD = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                countR++;
            } else {
                countD++;
            }
        }
        Node node1 = buildCycle(senate);
        Node node2;
        while (countD != 0 && countR != 0) {
            node2 = node1;
            while (node2.next.val == node1.val) {
                node2 = node2.next;
            }
            node2.next = node2.next.next;
            if (node1.val == 'R') {
                // System.out.println("删除了一个D");
                countD--;
            } else {
                // System.out.println("删除了一个R");
                countR--;
            }
            node1 = node1.next;
        }
        return countD == 0 ? "Radiant" : "Dire";
    }

    public Node buildCycle(String senate) {
        // 构造一个环
        Node dummyNode = new Node();
        Node curr = dummyNode;
        for (char c : senate.toCharArray()) {
            Node next = new Node(c);
            curr.next = next;
            curr = curr.next;
        }
        curr.next = dummyNode.next;
        return dummyNode.next;
    }
}

/**
 * 上个解法最大的问题在于每次都要检索敌对元素的位置，因此考虑用两个队列分别存储两个势力
 */
class Solution649_2 {
    public String predictPartyVictory(String senate) {
        Deque<Integer> dequeR = new LinkedList<>();
        Deque<Integer> dequeD = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                dequeR.offer(i);
            } else {
                dequeD.offer(i);
            }
        }
        // System.out.println(dequeR);
        // System.out.println(dequeD);
        int pre = -1;
        while (!dequeD.isEmpty() && !dequeR.isEmpty()) {
            int pD = dequeD.poll();
            int pR = dequeR.poll();
            int distD = pD > pre ? pD - pre : pD + senate.length() - pre;
            int distR = pR > pre ? pR - pre : pR + senate.length() - pre;
            if (distD < distR) {
                pre = pD;
                dequeD.offer(pD);
            } else {
                pre = pR;
                dequeR.offer(pR);
            }
        }
        return dequeD.isEmpty() ? "Radiant" : "Dire";
    }
}

/**
 * 上一个解法仍存在顺序确认麻烦的问题，考虑直接将遍历到的元素+N插回，而不是插入原值
 */
class Solution649_3 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}