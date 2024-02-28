import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

import util.TreeNode;

public class LeetCode94 {
    public static void main(String[] args) {
        System.out.println(new Solution94_2().inorderTraversal(TreeNode.buildTree(new Integer[] { 1, null, 2, 3 })));
        System.out.println("================================================");

        System.out.println(new Solution94_2().inorderTraversal(TreeNode.buildTree(new Integer[] {})));
        System.out.println("================================================");

        System.out.println(new Solution94_2().inorderTraversal(TreeNode.buildTree(new Integer[] { 1 })));
        System.out.println("================================================");
    }
}

class Solution94_1 {
    // NOTE: 递归版本
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> numbers = new ArrayList<Integer>();
        inorderTraversal(root, numbers);
        return numbers;
    }

    void inorderTraversal(TreeNode x, List<Integer> numbers) {
        if (x == null) {
            return;
        }
        inorderTraversal(x.left, numbers);
        numbers.add(x.val);
        inorderTraversal(x.right, numbers);
    }
}

class Solution94_2 {
    // NOTE: 迭代版本
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else {
                    res.add(cur.val);
                    if (cur.right != null) {
                        stack.push(cur.right);
                    } else {
                        stack.pop();
                    }
                }
            } else if (cur.right == pre) {
                stack.pop();
            } else if (cur.left == pre) {
                res.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    stack.pop();
                }
            }
            pre = cur;
        }

        return res;
    }
}