/* 
 * 问题描述: https://leetcode.cn/problems/path-sum/description/
 * 解题思路: DFS, BFS
 */

import util.TreeNode;

public class LeetCode112 {
    public static void main(String[] args) {
        TreeNode root;
        // 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        // 输出：true
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution112().hasPathSum(root, 22));

        // 输入：root = [1,2,3], targetSum = 5
        // 输出：false
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution112().hasPathSum(root, 5));

        // 输入：root = [], targetSum = 0
        // 输出：false
        root = null;
        System.out.println(new Solution112().hasPathSum(root, 0));

    }
}

class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            // 说明此时root是叶子结点
            if (targetSum == root.val) {
                // 叶子结点与需要的targetNum一致
                return true;
            } else {
                return false;
            }
        }
        targetSum -= root.val;
        if ((root.left != null && hasPathSum(root.left, targetSum))
                || (root.right != null && hasPathSum(root.right, targetSum))) {
            return true;
        } else {
            return false;
        }
    }
}
