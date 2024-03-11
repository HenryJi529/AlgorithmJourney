import java.util.Queue;
import java.util.LinkedList;

import util.TreeNode;

public class LeetCode101 {
    public static void main(String[] args) {
        // 输入：root = [1,2,2,3,4,4,3]
        // 输出：true
        System.out.println(new Solution101_2().isSymmetric(TreeNode.buildTree(new Integer[] { 1, 2, 2, 3, 4, 4, 3 })));

        // 输入：root = [1,2,2,null,3,null,3]
        // 输出：false
        System.out.println(
                new Solution101_2().isSymmetric(TreeNode.buildTree(new Integer[] { 1, 2, 2, null, 3, null, 3 })));
    }
}

class Solution101_1 {
    public boolean isSymmetric(TreeNode root) {
        Queue<Integer> queue = new LinkedList<Integer>();
        dfs_offer(queue, root);
        // System.out.println(queue);
        return dfs_pop(queue, root);
    }

    public void dfs_offer(Queue<Integer> queue, TreeNode root) {
        if (root == null) {
            queue.offer(Integer.MAX_VALUE);
            return;
        }
        queue.offer(root.val);
        dfs_offer(queue, root.left);
        dfs_offer(queue, root.right);
    }

    public boolean dfs_pop(Queue<Integer> queue, TreeNode root) {
        if (root == null) {
            if (queue.poll() == Integer.MAX_VALUE) {
                return true;
            } else {
                return false;
            }

        }
        if (queue.poll() == root.val) {
            return dfs_pop(queue, root.right) && dfs_pop(queue, root.left);
        } else {
            return false;
        }

    }
}

class Solution101_2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 调用递归函数，比较左节点，右节点
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        // 递归的终止条件是两个节点都为空
        // 或者两个节点中有一个为空
        // 或者两个节点的值不相等
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // 再递归的比较 左节点的左孩子 和 右节点的右孩子
        // 以及比较 左节点的右孩子 和 右节点的左孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
