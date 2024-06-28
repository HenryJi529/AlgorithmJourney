import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class LeetCode114 {
    public static void main(String[] args) {
        // 输入：root = [1,2,5,3,4,null,6]
        // 输出：[1,null,2,null,3,null,4,null,5,null,6]
        TreeNode root = null;
        root = TreeNode.buildTree(new Integer[] { 1, 2, 5, 3, 4, null, 6 });
        new Solution114().flatten(root);
        System.out.println(root);

        // 输入：root = []
        // 输出：[]
        root = TreeNode.buildTree(new Integer[] {});
        new Solution114().flatten(root);
        System.out.println(root);

        // 输入：root = [0]
        // 输出：[0]
        root = TreeNode.buildTree(new Integer[] { 0 });
        new Solution114().flatten(root);
        System.out.println(root);
    }
}

class Solution114 {
    public void flatten(TreeNode root) {
        List<TreeNode> order = new ArrayList<TreeNode>();
        dfs(root, order);
        TreeNode dumNode = new TreeNode();
        for (TreeNode node : order) {
            dumNode.left = null;
            dumNode.right = node;
            dumNode = dumNode.right;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> order) {
        if (root == null) {
            return;
        }
        order.add(root);
        dfs(root.left, order);
        dfs(root.right, order);
    }
}