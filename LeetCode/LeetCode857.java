import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode857 {
    public static void main(String[] args) {
        // 输入： quality = [10,20,5], wage = [70,50,30], k = 2
        // 输出： 105.00000
        // 解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
        System.out
                .println(new Solution857().mincostToHireWorkers(new int[] { 10, 20, 5 }, new int[] { 70, 50, 30 }, 2));

        // 输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
        // 输出： 30.66667
        // 解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
        System.out
                .println(new Solution857().mincostToHireWorkers(new int[] { 3, 1, 10, 10, 1
                },
                        new int[] { 4, 8, 2, 2, 7 },
                        3));

        // 输入： quality = [3,4,3], wage = [13,8,20], k = 1
        // 输出：8.0
        System.out
                .println(new Solution857().mincostToHireWorkers(new int[] { 3, 4, 3 },
                        new int[] { 13, 8, 20 },
                        1));
    }
}

class Solution857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = new Integer[n];
        for (int i = 0; i < n; i++) {
            h[i] = i;
        }
        Arrays.sort(h, (a, b) -> {
            // NOTE: 结果与w[i]/q[i] 升序相同
            return quality[b] * wage[a] - quality[a] * wage[b];
        });
        // System.out.println(Arrays.toString(quality));
        // System.out.println(Arrays.toString(wage));
        // System.out.println(Arrays.toString(h));
        double ans;
        double sum = 0;
        // 首先选取第k-1号工人(单位工资最高的)，所有工人的单位工资向工头看齐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(quality[h[i]]);
            sum += quality[h[i]];
        }
        ans = 1.0 * sum * wage[h[k - 1]] / quality[h[k - 1]];
        for (int i = k; i < n; i++) {
            int largestQuality = pq.poll();
            pq.add(quality[h[i]]);
            sum -= largestQuality;
            sum += quality[h[i]];
            ans = Math.min(ans, sum * wage[h[i]] / quality[h[i]]);
        }
        return ans;
    }
}