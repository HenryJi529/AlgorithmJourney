import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

import util.TreeNode;
import util.PrintUtil;

public class LeetCode102 {
    public static void main(String[] args) {
        // 输入：root = [3,9,20,null,null,15,7]
        // 输出：[[3],[9,20],[15,7]]
        PrintUtil.printNestedList(
                new Solution102().levelOrder(TreeNode.buildTree(new Integer[] { 3, 9, 20, null, null, 15, 7 })));

        // 输入：root = [1]
        // 输出：[[1]]
        PrintUtil.printNestedList(
                new Solution102().levelOrder(TreeNode.buildTree(new Integer[] { 1 })));

        // 输入：root = []
        // 输出：[]
        PrintUtil.printNestedList(
                new Solution102().levelOrder(TreeNode.buildTree(new Integer[] {})));
    }
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> nodes = new ArrayList<List<Integer>>();
        queue.offer(root);
        while (queue.size() > 0) {
            List<Integer> level = new ArrayList<Integer>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            nodes.add(level);
        }
        return nodes;
    }
}