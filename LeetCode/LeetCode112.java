import util.TreeNode;

public class LeetCode112 {
    public static void main(String[] args) {
        // 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        // 输出：true
        System.out.println(new Solution112().hasPathSum(
                TreeNode.buildTree(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 }), 22));

        // 输入：root = [1,2,3], targetSum = 5
        // 输出：false
        System.out.println(new Solution112().hasPathSum(
                TreeNode.buildTree(new Integer[] { 1, 2, 3 }), 5));

        // 输入：root = [], targetSum = 0
        // 输出：false
        System.out.println(new Solution112().hasPathSum(
                TreeNode.buildTree(new Integer[] {}), 0));
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
