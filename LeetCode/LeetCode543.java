import util.TreeNode;

public class LeetCode543 {
    public static void main(String[] args) {
        // 输入：root = [1,2,3,4,5]
        // 输出：3
        // 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
        System.out.println(new Solution543().diameterOfBinaryTree(TreeNode.buildTree(new Integer[] { 1, 2, 3, 4, 5 })));

        // 输入：root = [1,2]
        // 输出：1
        System.out.println(new Solution543().diameterOfBinaryTree(TreeNode.buildTree(new Integer[] { 1, 2 })));
    }
}

class Solution543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        ans = Math.max(leftMax + rightMax, ans);
        return Math.max(leftMax, rightMax) + 1;
    }
}
