import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

import util.TreeNode;

public class LeetCode145 {
    public static void main(String[] args) {
        // 输入：root = [1,null,2,3]
        // 输出：[3,2,1]
        System.out.println(new Solution145_2().postorderTraversal(TreeNode.buildTree(new Integer[] { 1, null, 2, 3 })));

        // 输入：root = []
        // 输出：[]
        System.out.println(new Solution145_2().postorderTraversal(TreeNode.buildTree(new Integer[] {})));

        // 输入：root = [1]
        // 输出：[1]
        System.out.println(new Solution145_2().postorderTraversal(TreeNode.buildTree(new Integer[] { 1 })));
    }
}

class Solution145_1 {
    // NOTE: 递归版本
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }
}

class Solution145_2 {
    // NOTE: 前序遍历左右节点调换后整个颠倒
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return res;
    }
}

class Solution145_3 {
    // NOTE: 传统的迭代版本
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (pre == null || pre.left == cur || pre.right == cur) {
                // 前一个访问的是父节点
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    stack.pop();
                    res.add(cur.val);
                }
            } else if (cur.left == pre) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pop();
                }
            } else {
                res.add(cur.val);
                stack.pop();
            }

            pre = cur;
        }
        return res;

    }
}