import java.util.Queue;
import java.util.LinkedList;

import util.TreeNode;

public class LeetCode104 {
    public static void main(String[] args) {
        // 输入：root = [3,9,20,null,null,15,7]
        // 输出：3
        System.out
                .println(new Solution104_2()
                        .maxDepth(TreeNode.buildTree(new Integer[] { 3, 9, 20, null, null, 15, 7 })));

        // 输入：root = [1,null,2]
        // 输出：2
        System.out
                .println(new Solution104_2().maxDepth(TreeNode.buildTree(new Integer[] { 1, null, 2 })));
    }
}

class Solution104_1 {
    // BFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans++;
        }
        return ans;
    }
}

class Solution104_2 {
    // DFS
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(dfs(node.left, depth), dfs(node.right, depth)) + 1;
    }
}