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

    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes.length == 0 || nodes[0] == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        TreeNode root = new TreeNode(nodes[0]);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i == nodes.length) {
                // 已经没有多余的节点了
                break;
            } else if (i == nodes.length - 1) {
                // 还剩下一个左节点
                if (nodes[i] != null) {
                    node.left = new TreeNode(nodes[i]);
                    queue.offer(node.left);
                }
                break;
            } else {
                if (nodes[i] != null) {
                    node.left = new TreeNode(nodes[i]);
                    queue.offer(node.left);
                }
                if (nodes[i + 1] != null) {
                    node.right = new TreeNode(nodes[i + 1]);
                    queue.offer(node.right);
                }
                i += 2;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        System.out.println(root);
    }
}
