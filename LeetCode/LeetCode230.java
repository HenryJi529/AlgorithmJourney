import util.TreeNode;

public class LeetCode230 {
    public static void main(String[] args) {
        // 输入：root = [3,1,4,null,2], k = 1
        // 输出：1
        System.out.println(new Solution230().kthSmallest(TreeNode.buildTree(new Integer[] { 3, 1, 4, null, 2 }), 1));

        // 输入：root = [5,3,6,2,4,null,null,1], k = 3
        // 输出：3
        System.out.println(
                new Solution230().kthSmallest(TreeNode.buildTree(new Integer[] { 5, 3, 6, 2,
                        4, null, null, 1 }), 3));

    }
}

class Solution230 {
    int result;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        k--;
        if (k == 0) {
            result = root.val;
        }
        dfs(root.right);
    }
}