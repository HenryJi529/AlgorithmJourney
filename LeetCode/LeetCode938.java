import util.TreeNode;

public class LeetCode938 {
    public static void main(String[] args) {
        // 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
        // 输出：32
        System.out.println(
                new Solution938().rangeSumBST(TreeNode.buildTree(new Integer[] { 10, 5, 15, 3, 7, null, 18 }), 7, 15));

        // 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
        // 输出：23
        System.out.println(
                new Solution938().rangeSumBST(TreeNode.buildTree(new Integer[] { 10, 5, 15, 3, 7, 13, 18, 1, null, 6 }),
                        6, 10));
    }
}

class Solution938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    public int dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;

        sum += root.val <= high && root.val >= low ? root.val : 0;
        sum += root.val >= low ? dfs(root.left, low, high) : 0;
        sum += root.val <= high ? dfs(root.right, low, high) : 0;
        return sum;
    }
}