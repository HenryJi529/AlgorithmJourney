import util.TreeNode;

public class LeetCode226 {
    public static void main(String[] args) {
        // 输入：root = [4,2,7,1,3,6,9]
        // 输出：[4,7,2,9,6,3,1]
        System.out.println(new Solution226().invertTree(TreeNode.buildTree(new Integer[] { 4, 2, 7, 1, 3, 6, 9 })));

        // 输入：root = [2,1,3]
        // 输出：[2,3,1]
        System.out.println(new Solution226().invertTree(TreeNode.buildTree(new Integer[] { 2, 1, 3 })));
    }
}

class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if (root == null)
            return;

        invert(root.left);
        invert(root.right);
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }
}