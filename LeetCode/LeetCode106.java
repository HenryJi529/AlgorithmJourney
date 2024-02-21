import util.TreeNode;

public class LeetCode106 {
    public static void main(String[] args) {
        // 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        // 输出：[3,9,20,null,null,15,7]
        System.out.println(new Solution106().buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }));

        // 输入：inorder = [-1], postorder = [-1]
        // 输出：[-1]
        System.out.println(new Solution106().buildTree(new int[] { -1 }, new int[] {
                -1 }));

        // 输入：inorder = [2,1], postorder = [2,1]
        // 输出：
        System.out.println(new Solution106().buildTree(new int[] { 2, 1 }, new int[] {
                2, 1 }));
    }
}

class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] inorder, int[] postorder, int in_start, int in_end, int post_start, int post_end) {
        if (in_start > in_end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_end], null, null);
        if (in_start == in_end) {
            return root;
        }

        // NOTE: 这里可以利用哈希表加速查询
        int root_pos = in_start;
        while (root_pos <= in_end) {
            if (inorder[root_pos] == root.val) {
                break;
            }
            root_pos++;
        }

        root.left = dfs(inorder, postorder, in_start, root_pos - 1, post_start, post_start + root_pos - 1 - in_start);
        root.right = dfs(inorder, postorder, root_pos + 1, in_end, post_start + root_pos - in_start, post_end - 1);
        return root;
    }
}