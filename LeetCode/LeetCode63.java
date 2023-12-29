public class LeetCode63 {
    public static void main(String[] args) {
        // 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        // 输出：2
        System.out.println(
                new Solution63().uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));

        // 输入：obstacleGrid = [[0,1],[0,0]]
        // 输出：1
        System.out.println(
                new Solution63().uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 }
                }));

        // 输入：obstacleGrid = [[1,0]]
        // 输出：0
        System.out.println(
                new Solution63().uniquePathsWithObstacles(new int[][] { { 1, 0 } }));

        // 输入：obstacleGrid = [[1]]
        // 输出：0
        System.out.println(
                new Solution63().uniquePathsWithObstacles(new int[][] { { 1 } }));
    }
}

class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        memo[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
        return dp(0, 0, obstacleGrid, memo);
    }

    public int dp(int m, int n, int[][] obstacleGrid, int[][] memo) {
        // System.out.println("IN: " + m + " " + n);
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (obstacleGrid[m][n] == 1) {
            return 0;
        }

        int res = 0;
        if (m + 1 < obstacleGrid.length && obstacleGrid[m + 1][n] != 1) {
            res += dp(m + 1, n, obstacleGrid, memo);
        }
        if (n + 1 < obstacleGrid[0].length && obstacleGrid[m][n + 1] != 1) {
            res += dp(m, n + 1, obstacleGrid, memo);
        }
        // System.out.println("OUT: " + m + " " + n + " " + res);
        memo[m][n] = res;
        return res;
    }

}