public class LeetCode64 {
    public static void main(String[] args) {
        // 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        // 输出：7
        System.out.println(new Solution64_2().minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));

        // 输入：grid = [[1,2,3],[4,5,6]]
        // 输出：12
        System.out.println(new Solution64_2().minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
    }
}

class Solution64_1 {
    // NOTE: 这个方法的填表中if太多了效率比较低
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else {
                    if (i == 0) {
                        dp[0][j] = dp[0][j - 1] + grid[0][j];
                    } else if (j == 0) {
                        dp[i][0] = dp[i - 1][0] + grid[i][0];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

class Solution64_2 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}