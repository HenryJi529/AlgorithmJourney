import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

import util.TreeNode;

public class LeetCode2583 {
    public static void main(String[] args) {
        // 输入：root = [5,8,9,2,1,3,7,4,6], k = 2
        // 输出：13
        System.out.println(new Solution2583()
                .kthLargestLevelSum(TreeNode.buildTree(new Integer[] { 5, 8, 9, 2, 1, 3, 7, 4, 6 }), 2));

        // 输入：root = [1,2,null,3], k = 1
        // 输出：3
        System.out.println(new Solution2583()
                .kthLargestLevelSum(TreeNode.buildTree(new Integer[] { 1, 2, null, 3 }), 1));
    }
}

class Solution2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (pq.size() < k) {
                pq.add(sum);
            } else {
                if (pq.peek() < sum) {
                    pq.poll();
                    pq.add(sum);
                }
            }
        }
        if (pq.size() < k) {
            return -1;
        } else {
            return pq.peek();
        }
    }
}