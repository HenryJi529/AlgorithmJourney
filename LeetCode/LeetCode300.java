import java.util.Arrays;

public class LeetCode300 {
    public static void main(String[] args) {
        // 输入：nums = [10,9,2,5,3,7,101,18]
        // 输出：4
        System.out.println(new Solution300().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));

        // 输入：nums = [0,1,0,3,2,3]
        // 输出：4
        System.out.println(new Solution300().lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));

        // 输入：nums = [7,7,7,7,7,7,7]
        // 输出：1
        System.out.println(new Solution300().lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));

    }
}

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}