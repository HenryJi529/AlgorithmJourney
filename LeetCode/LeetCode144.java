import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

import util.TreeNode;

public class LeetCode144 {
    public static void main(String[] args) {
        // 输入：root = [1,null,2,3]
        // 输出：[1,2,3]
        System.out.println(Arrays.toString(
                new Solution144_2().preorderTraversal(TreeNode.buildTree(new Integer[] { 1, null, 2, 3 })).toArray()));

        // 输入：root = []
        // 输出：[]
        System.out.println(Arrays.toString(
                new Solution144_2().preorderTraversal(TreeNode.buildTree(new Integer[] {})).toArray()));

        // 输入：root = [1]
        // 输出：[1]
        System.out.println(Arrays.toString(
                new Solution144_2().preorderTraversal(TreeNode.buildTree(new Integer[] { 1 })).toArray()));

        // 输入：root = [1,2]
        // 输出：[1,2]
        System.out.println(Arrays.toString(
                new Solution144_2().preorderTraversal(TreeNode.buildTree(new Integer[] { 1, 2 })).toArray()));

        // 输入：root = [1,null,2]
        // 输出：[1,2]
        System.out.println(Arrays.toString(
                new Solution144_2().preorderTraversal(TreeNode.buildTree(new Integer[] { 1, null, 2 })).toArray()));

        // 输入：root = [3,1,2]
        // 输出：[3,1,2]
        System.out.println(Arrays.toString(
                new Solution144_2().preorderTraversal(TreeNode.buildTree(new Integer[] { 3, 1, 2 })).toArray()));
    }
}

class Solution144_1 {
    // NOTE: 递归版本
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

class Solution144_2 {
    // NOTE: 迭代版本
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }
}