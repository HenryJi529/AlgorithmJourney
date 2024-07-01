import util.TreeNode;

public class LeetCode108 {
    public static void main(String[] args) {
        // 输入：nums = [-10,-3,0,5,9]
        // 输出：[0,-3,9,-10,null,5]
        System.out.println(new Solution108().sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }));

        // 输入：nums = [1,3]
        // 输出：[3,1]
        System.out.println(new Solution108().sortedArrayToBST(new int[] { 1, 3 }));
    }
}

class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toTree(nums, 0, nums.length - 1);
    }

    public TreeNode toTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toTree(nums, start, mid - 1);
        root.right = toTree(nums, mid + 1, end);
        return root;
    }
}