import util.TreeNode;

public class LeetCode124 {
    public static void main(String[] args) {
        // 输入：root = [1,2,3]
        // 输出：6
        System.out.println(new Solution124().maxPathSum(TreeNode.buildTree(new Integer[] { 1, 2, 3 })));

        // 输入：root = [-10,9,20,null,null,15,7]
        // 输出：42
        System.out.println(
                new Solution124().maxPathSum(TreeNode.buildTree(new Integer[] { -10, 9, 20, null, null, 15, 7 })));

        // 输入：root = [-3]
        // 输出：-3
        System.out.println(
                new Solution124().maxPathSum(TreeNode.buildTree(new Integer[] { -3 })));

        // 输入：root = [2,-1]
        // 输出：2
        System.out.println(
                new Solution124().maxPathSum(TreeNode.buildTree(new Integer[] { 2, -1 })));

    }
}

class Solution124 {
    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        int left = node.left != null ? dfs(node.left) : 0;
        int right = node.right != null ? dfs(node.right) : 0;
        this.max = Math.max(left + right + node.val, max);
        // NOTE: 存在不上传的情况
        return Math.max(Math.max(left + node.val, right + node.val), 0);
    }
}