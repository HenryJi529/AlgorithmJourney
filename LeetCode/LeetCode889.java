import java.util.HashMap;

import util.TreeNode;

public class LeetCode889 {
    public static void main(String[] args) {
        // 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
        // 输出：[1,2,3,4,5,6,7]
        System.out.println(new Solution889().constructFromPrePost(new int[] { 1, 2, 4, 5, 3, 6, 7 },
                new int[] { 4, 5, 2, 6, 7, 3, 1 }));

        // 输入: preorder = [1], postorder = [1]
        // 输出: [1]
        System.out.println(new Solution889().constructFromPrePost(new int[] { 1 },
                new int[] { 1 }));
    }
}

class Solution889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return dfs(postMap, preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode dfs(HashMap<Integer, Integer> postMap, int[] preorder, int[] postorder, int pre_start, int pre_end,
            int post_start, int post_end) {
        if (pre_start > pre_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_start]);
        if (pre_start < pre_end) {
            int post_leftRoot = postMap.get(preorder[pre_start + 1]); // NOTE: 实际上pre_start+1不一定属于左子树
            root.left = dfs(postMap, preorder, postorder, pre_start + 1, pre_start + post_leftRoot - post_start + 1,
                    post_start, post_leftRoot);
            root.right = dfs(postMap, preorder, postorder, pre_start + post_leftRoot - post_start + 2, pre_end,
                    post_leftRoot + 1, post_end);
        }
        return root;
    }
}
