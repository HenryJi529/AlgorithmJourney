import util.TreeNode;

public class LeetCode129 {
    public static void main(String[] args) {
        // 输入：root = [1,2,3]
        // 输出：25
        System.out.println(new Solution129().sumNumbers(TreeNode.buildTree(new Integer[] { 1, 2, 3 })));

        // 输入：root = [4,9,0,5,1]
        // 输出：1026
        System.out.println(new Solution129().sumNumbers(TreeNode.buildTree(new Integer[] { 4, 9, 0, 5, 1 })));
    }
}

class Solution129 {
    public int globalSum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return globalSum;
    }

    public void dfs(TreeNode node, int sum) {
        int temp = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            this.globalSum += temp;
        }
        if (node.left != null) {
            dfs(node.left, temp);
        }
        if (node.right != null) {
            dfs(node.right, temp);
        }
    }
}