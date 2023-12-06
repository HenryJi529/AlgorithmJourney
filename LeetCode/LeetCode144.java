import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.TreeNode;

public class LeetCode144 {
    public static void main(String[] args) {
        TreeNode root;
        // 输入：root = [1,null,2,3]
        // 输出：[1,2,3]
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new Solution144().preorderTraversal(root).toArray()));

        // 输入：root = []
        // 输出：[]
        root = null;
        System.out.println(Arrays.toString(new Solution144().preorderTraversal(root).toArray()));

        // 输入：root = [1]
        // 输出：[1]
        root = new TreeNode(1);
        System.out.println(Arrays.toString(new Solution144().preorderTraversal(root).toArray()));

        // 输入：root = [1,2]
        // 输出：[1,2]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(Arrays.toString(new Solution144().preorderTraversal(root).toArray()));

        // 输入：root = [1,null,2]
        // 输出：[1,2]
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(Arrays.toString(new Solution144().preorderTraversal(root).toArray()));

        // 输入：root = [3,1,2]
        // 输出：[3,1,2]
        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(Arrays.toString(new Solution144().preorderTraversal(root).toArray()));
    }
}

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
