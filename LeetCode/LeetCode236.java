import util.TreeNode;

public class LeetCode236 {
    public static void main(String[] args) {
        TreeNode root;
        // 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        // 输出：3
        // 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
        root = TreeNode.buildTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
        System.out.println(
                new Solution236().lowestCommonAncestor(root, TreeNode.search(root, 5), TreeNode.search(root, 1)).val);

        // 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        // 输出：5
        // 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
        root = TreeNode.buildTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
        System.out.println(
                new Solution236().lowestCommonAncestor(root, TreeNode.search(root, 5), TreeNode.search(root, 4)).val);

        // 输入：root = [1,2], p = 1, q = 2
        // 输出：1
        root = TreeNode.buildTree(new Integer[] { 1, 2 });
        System.out.println(
                new Solution236().lowestCommonAncestor(root, TreeNode.search(root, 1), TreeNode.search(root, 2)).val);
    }
}

class Solution236 {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean[] dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new boolean[] { false, false };
        }
        boolean[] left = dfs(root.left, p, q);
        boolean[] right = dfs(root.right, p, q);
        boolean[] current = new boolean[] { left[0] || right[0] || p == root, left[1] || right[1] || q == root };
        if (current[0] && current[1] && ans == null) {
            ans = root;
        }
        return current;
    }
}