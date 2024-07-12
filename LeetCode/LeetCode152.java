public class LeetCode152 {
    public static void main(String[] args) {
        // 输入: nums = [2,3,-2,4]
        // 输出: 6
        System.out.println(new Solution152().maxProduct(new int[] { 2, 3, -2, 4 }));

        // 输入: nums = [-2,0,-1]
        // 输出: 0
        System.out.println(new Solution152().maxProduct(new int[] { -2, 0, -1 }));

        // 输入: nums = [-2,3,-4]
        // 输出: 24
        System.out.println(new Solution152().maxProduct(new int[] { -2, 3, -4 }));
    }
}

class Solution152 {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2]; // 代表以dp[i]结尾的最大数组/相反数最大子数组的值

        int ans = nums[0];
        if (nums[0] > 0) {
            dp[0][0] = nums[0];
        } else {
            dp[0][1] = nums[0]; // NOTE: 0的话无所谓
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = dp[i - 1][1] * nums[i];
            } else if (nums[i] < 0) {
                dp[i][0] = dp[i - 1][1] * nums[i];
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
            } else {
                ans = Math.max(0, ans);
            }
            ans = Math.max(dp[i][0], ans);
        }

        return ans;
    }
}