import util.TreeNode;

public class LeetCode450 {
    public static void main(String[] args) {
        // 输入：root = [5,3,6,2,4,null,7], key = 3
        // 输出：[5,4,6,2,null,null,7]
        System.out
                .println(new Solution450().deleteNode(TreeNode.buildTree(new Integer[] { 5, 3, 6, 2, 4, null, 7 }), 3));

        // 输入: root = [5,3,6,2,4,null,7], key = 0
        // 输出: [5,3,6,2,4,null,7]
        System.out
                .println(new Solution450().deleteNode(TreeNode.buildTree(new Integer[] { 5,
                        3, 6, 2, 4, null, 7 }), 0));

        // 输入: root = [], key = 0
        // 输出: []
        System.out
                .println(new Solution450().deleteNode(TreeNode.buildTree(new Integer[] {}),
                        0));
    }
}

class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return getNewRoot(root);
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.val > key) {
                pre = cur;
                cur = cur.left;
            } else if (cur.val < key) {
                pre = cur;
                cur = cur.right;
            } else {
                break;
            }
        }
        if (cur != null) {
            if (pre.left == cur) {
                pre.left = getNewRoot(cur);
            } else {
                pre.right = getNewRoot(cur);
            }
        }
        return root;
    }

    public TreeNode findLeftMost(TreeNode currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public TreeNode getNewRoot(TreeNode root) {
        if (root.left != null && root.right != null) {
            findLeftMost(root.right).left = root.left;
            return root.right;
        } else {
            if (root.right == null) {
                return root.left;
            } else {
                return root.right;
            }
        }
    }

}
