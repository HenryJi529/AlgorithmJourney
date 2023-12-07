package util;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.offer(this);
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node != null) {
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                list.add(null);
            }
        }
        return list.toString();
    }
}
