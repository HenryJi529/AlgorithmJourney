import util.TreeNode;

public class LeetCode98 {
    public static void main(String[] args) {
        // 输入：root = [2,1,3]
        // 输出：true
        System.out.println(new Solution98_1().isValidBST(TreeNode.buildTree(new Integer[] { 2, 1, 3 })));

        // 输入：root = [5,1,4,null,null,3,6]
        // 输出：false
        System.out
                .println(
                        new Solution98_1().isValidBST(TreeNode.buildTree(new Integer[] { 5, 1, 4, null, null, 3, 6 })));

        // 输入：[5,4,6,null,null,3,7]
        // 输出：true
        System.out
                .println(
                        new Solution98_1().isValidBST(TreeNode.buildTree(new Integer[] { 5, 4, 6, null, null, 3, 7 })));
    }
}

class Solution98_1 {
    // NOTE: 假定左右子树均为二叉查找树，那么判断左/右子树的最大/最小节点是否满足要求
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left) && isValidBST(root.right)) {
            TreeNode leftSubTreeMax = root.left;
            while (leftSubTreeMax != null && leftSubTreeMax.right != null) {
                leftSubTreeMax = leftSubTreeMax.right;
            }
            if (leftSubTreeMax != null && leftSubTreeMax.val >= root.val) {
                return false;
            }
            TreeNode rightSubTreeMin = root.right;
            while (rightSubTreeMin != null && rightSubTreeMin.left != null) {
                rightSubTreeMin = rightSubTreeMin.left;
            }
            if (rightSubTreeMin != null && rightSubTreeMin.val <= root.val) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}

class Solution98_2 {
    // NOTE: 用上下界限来判断root的值是否合理
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
