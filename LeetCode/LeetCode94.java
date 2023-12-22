import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class LeetCode94 {
    public static void main(String[] args) {
        System.out.println(new Solution94().inorderTraversal(TreeNode.buildTree(new Integer[] { 1, null, 2, 3 })));
        System.out.println("================================================");

        System.out.println(new Solution94().inorderTraversal(TreeNode.buildTree(new Integer[] {})));
        System.out.println("================================================");

        System.out.println(new Solution94().inorderTraversal(TreeNode.buildTree(new Integer[] { 1 })));
        System.out.println("================================================");
    }
}

class Solution94 {
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