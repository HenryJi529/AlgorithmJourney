import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class LeetCode199 {
    public static void main(String[] args) {
        // 输入: [1,2,3,null,5,null,4]
        // 输出: [1,3,4]
        System.out.println(
                Arrays.toString(new Solution199()
                        .rightSideView(TreeNode.buildTree(new Integer[] { 1, 2, 3, null, 5, null, 4 })).toArray()));

        // 输入: [1,null,3]
        // 输出: [1,3]
        System.out.println(
                Arrays.toString(new Solution199()
                        .rightSideView(TreeNode.buildTree(new Integer[] { 1, null, 3 })).toArray()));

        // 输入: []
        // 输出: []
        System.out.println(
                Arrays.toString(new Solution199()
                        .rightSideView(TreeNode.buildTree(new Integer[] {})).toArray()));
    }
}

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res.add(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return res;
    }
}