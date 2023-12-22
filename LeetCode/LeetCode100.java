import java.util.Queue;
import java.util.LinkedList;
import util.TreeNode;

public class LeetCode100 {
    public static void main(String[] args) {
        TreeNode p, q;
        // 输入：p = [1,2,3], q = [1,2,3]
        // 输出：true
        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(new Solution100_1().isSameTree(p, q));

        // 输入：p = [1,2], q = [1,null,2]
        // 输出：false
        p = new TreeNode(1);
        p.left = new TreeNode(2);
        q = new TreeNode(1);
        q.left = null;
        q.right = new TreeNode(2);
        System.out.println(new Solution100_1().isSameTree(p, q));

        // 输入：p = [1,2,1], q = [1,1,2]
        // 输出：false
        p = new TreeNode(1);
        p.left = new TreeNode(2);
        q.right = new TreeNode(1);
        q = new TreeNode(1);
        p.left = new TreeNode(1);
        q.right = new TreeNode(2);
        System.out.println(new Solution100_1().isSameTree(p, q));
    }
}

class Solution100_1 {
    // NOTE: BFS角度
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
        } else {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();

        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            p = queue1.poll();
            q = queue2.poll();

            if (p.val != q.val) {
                return false;
            }
            if (p.left != null && q.left != null) {
                queue1.offer(p.left);
                queue2.offer(q.left);
            } else if (p.left == null && q.left == null) {
            } else {
                return false;
            }
            if (p.right != null && q.right != null) {
                queue1.offer(p.right);
                queue2.offer(q.right);
            } else if (p.right == null && q.right == null) {

            } else {
                return false;
            }

        }

        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}

class Solution101_2 {
    // NOTE: DFS角度
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
