import java.util.HashMap;

import util.TreeNode;

public class LeetCode105 {
    public static void main(String[] args) {
        // 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        // 输出: [3,9,20,null,null,15,7]
        System.out.println(new Solution105().buildTree(new int[] { 3, 9, 20, 15, 7 },
                new int[] { 9, 3, 15, 20, 7 }));

        // 输入: preorder = [-1], inorder = [-1]
        // 输出: [-1]
        System.out.println(new Solution105().buildTree(new int[] { -1 }, new int[] {
                -1 }));

        // 输入: preorder = [1,2], inorder = [2,1]
        // 输出: [1,2]
        System.out.println(new Solution105().buildTree(new int[] { 1, 2 }, new int[] { 2, 1 }));

        // 输入: preorder = [1,2,3], inorder = [3,2,1]
        // 输出: [1,2,null,3]
        System.out.println(new Solution105().buildTree(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }));
    }
}

class Solution105 {
    // NOTE: 之所以运行的慢，是因为只考虑了preorder的边界，没考虑inorder的边界
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = dfs(map, preorder, inorder, 0, inorder.length - 1);

        return root;
    }

    private TreeNode dfs(HashMap<Integer, Integer> map, int[] preorder, int[] inorder, int start, int end) {
        int prePointer = start;
        int inPointer = map.get(preorder[prePointer]);
        // System.out.println(
        // String.format("start: %d; end: %d; prePointer: %d; inPointer: %d", start,
        // end, prePointer, inPointer));

        TreeNode root = new TreeNode(preorder[prePointer]);
        if (start < end) {
            int leftStart, leftEnd, rightStart, rightEnd;
            int i = prePointer + 1;
            while (i <= end && map.get(preorder[i]) < inPointer) {
                i++;
            }
            rightStart = i;
            rightEnd = end;
            leftStart = prePointer + 1;
            leftEnd = rightStart - 1;

            if (leftStart <= leftEnd) {
                if (leftStart == rightStart) {
                    root.left = new TreeNode(preorder[leftStart]);
                } else {
                    root.left = dfs(map, preorder, inorder, leftStart, leftEnd);
                }
            }
            if (rightStart <= rightEnd) {
                if (rightStart == rightEnd) {
                    root.right = new TreeNode(preorder[rightStart]);
                } else {
                    root.right = dfs(map, preorder, inorder, rightStart, rightEnd);
                }
            }
        }
        return root;
    }
}