import java.util.HashMap;

import util.TreeNode;

public class LeetCode437 {
    public static void main(String[] args) {
        // 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        // 输出：3
        // 解释：和等于 8 的路径有 3 条，如图所示。
        System.out.println(new Solution437_2()
                .pathSum(TreeNode.buildTree(new Integer[] { 10, 5, -3, 3, 2, null, 11, 3, -2,
                        null, 1 }), 8));

        // 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        // 输出：3
        System.out.println(new Solution437_2()
                .pathSum(TreeNode.buildTree(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2,
                        null, null, 5, 1 }), 22));

        // 输入：root = [1,null,2,null,3,null,4,null,5], targetSum = 3
        // 输出：2
        System.out.println(new Solution437_2()
                .pathSum(TreeNode.buildTree(new Integer[] { 1, null, 2, null, 3, null, 4,
                        null, 5 }), 3));

    }
}

/**
 * 两层DFS，pathSum用于遍历root节点，rootSum用于统计以某个root节点开始的路径树
 */
class Solution437_1 {
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = root.val == targetSum ? 1 : 0;
        ret += rootSum(root.left, targetSum - root.val);
        ret += rootSum(root.right, targetSum - root.val);
        return ret;
    }
}

/**
 * 通过前缀和，计算以当前节点结尾的有效路径数
 */
class Solution437_2 {
    HashMap<Long, Integer> prefix = new HashMap<>();
    long targetSum;

    public int pathSum(TreeNode root, long targetSum) {
        this.targetSum = targetSum;
        prefix.put(0L, 1);
        return dfs(root, 0L);
    }

    public int dfs(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        // System.out.println(root.val);
        sum += root.val;

        int res = prefix.getOrDefault(sum - targetSum, 0);
        prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        res += dfs(root.left, sum);
        res += dfs(root.right, sum);
        prefix.put(sum, prefix.getOrDefault(sum, 0) - 1);
        return res;
    }
}
