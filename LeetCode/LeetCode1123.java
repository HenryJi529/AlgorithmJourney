import util.TreeNode;

public class LeetCode1123 {
    public static void main(String[] args) {
        // 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
        // 输出：[2,7,4]
        System.out.println(new Solution1123()
                .lcaDeepestLeaves(TreeNode.buildTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8,
                        null, null, 7, 4 })));

        // 输入：root = [1]
        // 输出：[1]
        System.out.println(new Solution1123()
                .lcaDeepestLeaves(TreeNode.buildTree(new Integer[] { 1 })));

        // 输入：root = [0,1,3,null,2]
        // 输出：[2]
        System.out.println(new Solution1123()
                .lcaDeepestLeaves(TreeNode.buildTree(new Integer[] { 0, 1, 3, null, 2 })));

        // 输入：root = [1,2,null,3,4,null,null,5]
        // 输出：[5]
        System.out.println(new Solution1123()
                .lcaDeepestLeaves(TreeNode.buildTree(new Integer[] { 1, 2, null, 3, 4, null, null, 5 })));
    }
}

class Solution1123 {
    TreeNode resNode;
    int resSelfDepth = Integer.MAX_VALUE;
    int resChildDepth = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        resNode = root;
        preorder(root, 0);
        return resNode;
    }

    public int preorder(TreeNode root, int currentDepth) {
        if (root == null) {
            return -1;
        }
        // System.out.println(root.val);
        int leftTreeHeight = preorder(root.left, currentDepth + 1);
        int rightTreeHeight = preorder(root.right, currentDepth + 1);
        int currentHeight = Math.max(leftTreeHeight + 1, rightTreeHeight + 1);
        // System.out.println(String.format("resSelfDepth: %d; resChildDepth:
        // %d;resNodeValue: %d", resSelfDepth,
        // resChildDepth, resNode.val));
        // System.out
        // .println(String.format("Value: %d; Depth: %d; Height: %d; leftHeight:
        // %d;rightHeight: %d", root.val,
        // currentDepth, currentHeight, leftTreeHeight, rightTreeHeight));

        if (leftTreeHeight == rightTreeHeight) {
            // 两子树要一样高
            if (resChildDepth < currentHeight + currentDepth) {
                // 最大的节点深度
                resChildDepth = currentHeight + currentDepth;
                resSelfDepth = currentDepth;
                resNode = root;
            } else if (resChildDepth == currentHeight + currentDepth) {
                if (currentDepth < resSelfDepth) {
                    resSelfDepth = currentDepth;
                    resNode = root;
                }
            }
        }

        return currentHeight;
    }
}
