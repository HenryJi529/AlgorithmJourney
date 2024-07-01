public class LeetCode53 {
    public static void main(String[] args) {
        // 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        // 输出：6
        System.out.println(new Solution53_2().maxSubArray(new int[] { -2, 1, -3, 4,
                -1, 2, 1, -5, 4 }));

        // 输入：nums = [1]
        // 输出：1
        System.out.println(new Solution53_2().maxSubArray(new int[] { 1 }));

        // 输入：nums = [5,4,-1,7,8]
        // 输出：23
        System.out.println(new Solution53_2().maxSubArray(new int[] { 5, 4, -1, 7, 8
        }));

    }
}

/**
 * 会超时【通过203/210】
 */
class Solution53_1 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int[] record = new int[nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                record[i] = record[i] + nums[i + len - 1];
                ans = Math.max(ans, record[i]);
            }
        }
        return ans;
    }
}

class Solution53_2 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}