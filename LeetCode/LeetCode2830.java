import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class LeetCode2830 {
    public static void main(String[] args) {
        // 输入：n = 5, offers = [[0,0,1],[0,2,2],[1,3,2]]
        // 输出：3
        System.out.println(
                new Solution2830_1().maximizeTheProfit(5,
                        Arrays.asList(List.of(0, 0, 1), List.of(0, 2, 2), List.of(1, 3, 2))));

        // 输入：n = 5, offers = [[0,0,1],[0,2,10],[1,3,2]]
        // 输出：10
        System.out.println(
                new Solution2830_2().maximizeTheProfit(5,
                        Arrays.asList(List.of(0, 0, 1), List.of(0, 2, 10), List.of(1, 3, 2))));
    }
}

class Solution2830_1 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        // 先按照start+, end++, gold--的顺序排列
        Collections.sort(offers, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });
        // PrintUtil.printNestedList(offers);
        int[] dp = new int[n + 1]; // 表示终点为i(不包括)的最大收入
        dp[0] = 0;
        for (int end = 1; end < dp.length; end++) {
            // 找到所有结尾为end-1的offer，且开价最高【根据start不同，可能有多个】
            // 如果根据end排序，就可以获得密集的一段，先二分查找end为目标值的开始位置
            int max = dp[end - 1];
            int startIndex = binarySearch(offers, end - 1);
            List<Integer> offer = null;
            for (int i = startIndex; i < offers.size(); i++) {
                offer = offers.get(i);
                if (offer.get(1) == end - 1) {
                    max = Math.max(max, dp[offer.get(0)] + offer.get(2));
                }
                if (offer.get(1) > end - 1) {
                    break;
                }
            }
            dp[end] = max;
            // System.out.println(String.format("dp[%d] = %d", end, max));
        }
        return dp[n];
    }

    public int binarySearch(List<List<Integer>> offers, int target) {
        // System.out.println(target);
        int left = 0;
        int right = offers.size() - 1;
        List<Integer> offer;
        int mid;
        while (left < right) {
            // System.out.println(left + " " + right);
            // try {
            // Thread.sleep(100);
            // } catch (InterruptedException e) {
            // // 处理中断异常
            // }
            mid = left + (right - left) / 2;
            offer = offers.get(mid);

            if (offer.get(1) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

class Solution2830_2 {
    // NOTE: 按照end分组，用空间换时间
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        @SuppressWarnings("unchecked")
        List<int[]>[] groups = new ArrayList[n];
        Arrays.setAll(groups, e -> new ArrayList<>());
        for (var offer : offers)
            groups[offer.get(1)].add(new int[] { offer.get(0), offer.get(2) });

        var f = new int[n + 1];
        for (int end = 0; end < n; end++) {
            f[end + 1] = f[end];
            for (var p : groups[end])
                f[end + 1] = Math.max(f[end + 1], f[p[0]] + p[1]);
        }
        return f[n];
    }
}