
public class LeetCode62 {
    public static void main(String[] args) {
        // 输入：m = 3, n = 7
        // 输出：28
        System.out.println(new Solution62().uniquePaths(3, 7));

        // 输入：m = 3, n = 2
        // 输出：3
        System.out.println(new Solution62().uniquePaths(3, 2));

        // 输入：m = 7, n = 3
        // 输出：28
        System.out.println(new Solution62().uniquePaths(7, 3));

        // 输入：m = 3, n = 3
        // 输出：6
        System.out.println(new Solution62().uniquePaths(3, 3));
    }
}

class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        // NOTE: 空间复杂度可以通过对称降低
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        memo[1][1] = 0;
        memo[2][1] = 1;
        memo[1][2] = 1;
        dp(m, n, memo);
        return memo[m][n];
    }

    public int dp(int m, int n, int[][] memo) {
        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        int res = 0;
        if (m - 1 >= 1) {
            res += dp(m - 1, n, memo);
        }
        if (n - 1 >= 1) {
            res += dp(m, n - 1, memo);
        }
        memo[m][n] = res;
        return res;
    }
}