import java.util.Arrays;
import java.util.Comparator;

public class LeetCode2008 {
    public static void main(String[] args) {
        // 输入：n = 5, rides = [[2,5,4],[1,5,1]]
        // 输出：7
        System.out.println(new Solution2008().maxTaxiEarnings(5, new int[][] { { 2, 5, 4 }, { 1, 5, 1 } }));

        // 输入：n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
        // 输出：20
        System.out.println(new Solution2008().maxTaxiEarnings(20,
                new int[][] { { 1, 6, 1 }, { 3, 10, 2 }, { 10, 12, 3 }, { 11, 12, 2 }, { 12, 15, 2 }, { 13, 18, 1 } }));

    }
}

class Solution2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        for (int i = 0; i < rides.length; i++) {
            rides[i][2] = rides[i][2] + rides[i][1] - rides[i][0];
        }
        // System.out.println(Arrays.deepToString(rides));
        long[] dp = new long[n + 1];
        int fromIndex = 0;
        for (int end = 1; end <= n; end++) {
            dp[end] = dp[end - 1];
            for (int index = fromIndex; index < rides.length; index++) {
                if (rides[index][1] > end) {
                    fromIndex = index;
                    break;
                }
                dp[end] = Math.max(dp[end],
                        dp[rides[index][0]] + rides[index][2]);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}