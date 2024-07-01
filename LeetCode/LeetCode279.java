import java.util.Arrays;

public class LeetCode279 {

    public static void main(String[] args) {
        // 输入：n = 12
        // 输出：3
        System.out.println(new Solution279().numSquares(12));

        // 输入：n = 13
        // 输出：2
        System.out.println(new Solution279().numSquares(13));
    }
}

class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                count = Math.min(count, dp[i - j * j]);
            }
            dp[i] = count + 1;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
