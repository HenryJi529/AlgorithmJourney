import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode354 {
    public static void main(String[] args) {
        // 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
        // 输出：3
        System.out.println(new Solution354_2().maxEnvelopes(new int[][] { { 5, 4 }, {
                6, 4 }, { 6, 7 }, { 2, 3 } }));

        // 输入：envelopes = [[1,1],[1,1],[1,1]]
        // 输出：1
        System.out.println(new Solution354_2().maxEnvelopes(new int[][] { { 1, 1 }, {
                1, 1 }, { 1, 1 } }));

        // 输入：envelopes = [[4,5],[4,6],[6,7],[2,3],[1,1]]
        // 输出：4
        System.out.println(
                new Solution354_2().maxEnvelopes(new int[][] { { 4, 5 }, { 4, 6 }, { 6, 7 }, {
                        2, 3 }, { 1, 1 } }));

        // 输入：envelopes = [[30,50],[12,2],[3,4],[12,15]]
        // 输出：3
        System.out.println(
                new Solution354_2().maxEnvelopes(new int[][] { { 30, 50 }, { 12, 2 }, { 3, 4 },
                        { 12, 15 } }));

        // 输入：envelopes = [[1,3],[3,5],[6,7],[6,8],[8,4],[9,5]]
        // 输出：3
        System.out.println(
                new Solution354_2()
                        .maxEnvelopes(new int[][] { { 1, 3 }, { 3, 5 }, { 6, 7 }, { 6, 8 }, { 8, 4 }, { 9, 5 } }));
    }
}

class Solution354_1 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1) {
            return 1;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // System.out.println(Arrays.deepToString(envelopes));
        // NOTE: 经过这段排序，只要是从左向右找关于h的最长子序列，并且w维度不相等即可

        // NOTE: 定义dp[i]为以i结尾的LIS长度
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] != envelopes[j][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return max;
    }
}

class Solution354_2 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1) {
            return 1;
        }
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        // System.out.println(Arrays.deepToString(envelopes));
        // NOTE: 经过这段排序，排除了相同宽度的干扰问题

        // NOTE: 定义dp[i]为长度为i+1的LIS尾部的元素值
        List<Integer> dp = new ArrayList<Integer>();
        dp.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            int index = Collections.binarySearch(dp, envelopes[i][1]);
            if (index < 0) {
                if (-index - 1 == dp.size()) {
                    dp.add(envelopes[i][1]);
                } else {
                    dp.set(-index - 1, envelopes[i][1]);
                }
            }
        }
        return dp.size();
    }
}
