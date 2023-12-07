import util.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {
    public static void main(String[] args) {
        var tree1 = new TreeNode(Integer.valueOf(1));
        tree1.right = new TreeNode(Integer.valueOf(2));
        tree1.right.left = new TreeNode(Integer.valueOf(3));
        List<Integer> numbers1 = new Solution94().inorderTraversal(tree1);
        System.out.println(numbers1);
        System.out.println("================================================");

        var tree2 = new TreeNode(1);
        List<Integer> numbers2 = new Solution94().inorderTraversal(tree2);
        System.out.println(numbers2);
        System.out.println("================================================");

        var tree3 = new TreeNode();
        List<Integer> numbers3 = new Solution94().inorderTraversal(tree3);
        System.out.println(numbers3);
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