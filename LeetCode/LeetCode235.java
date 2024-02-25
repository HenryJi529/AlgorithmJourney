import util.TreeNode;

public class LeetCode235 {
    public static void main(String[] args) {
        TreeNode root;
        // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        // 输出: 6
        root = TreeNode.buildTree(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
        System.out.println(new Solution235().lowestCommonAncestor(root, root.left, root.right).val);

        // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        // 输出: 2
        root = TreeNode.buildTree(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
        System.out.println(new Solution235().lowestCommonAncestor(root, root.left, root.left.right).val);
    }
}

class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if ((node.val < p.val && node.val > q.val) || node.val > p.val && node.val < q.val) {
                break;
            } else if (node.val == p.val || node.val == q.val) {
                break;
            } else {
                if (node.val < p.val && node.val < q.val) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
        return node;
    }
}