import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode300 {
    public static void main(String[] args) {
        // 输入：nums = [10,9,2,5,3,7,101,18]
        // 输出：4
        System.out.println(new Solution300_3().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));

        // 输入：nums = [0,1,0,3,2,3]
        // 输出：4
        System.out.println(new Solution300_3().lengthOfLIS(new int[] { 0, 1, 0, 3, 2,
                3 }));

        // 输入：nums = [7,7,7,7,7,7,7]
        // 输出：1
        System.out.println(new Solution300_3().lengthOfLIS(new int[] { 7, 7, 7, 7, 7,
                7, 7 }));

    }
}

class Solution300_1 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return max;
    }
}

class Solution300_2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // NOTE: dp[i]表示长度为i的LIS的末尾元素
        List<Integer> dp = new ArrayList<Integer>();
        dp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int index = Collections.binarySearch(dp, nums[i]);
            if (index < 0) {
                if (-index - 1 == dp.size()) {
                    dp.add(nums[i]);
                } else {
                    dp.set(-index - 1, nums[i]);
                }
            } else {
                if (dp.get(index) > nums[i]) {
                    dp.set(index, nums[i]);
                }
            }
        }
        return dp.size();
    }
}

/**
 * 针对方案1的负优化: 使用pq来挑选合适的上一个元素【操作更为复杂了】
 */
class Solution300_3 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        Arrays.fill(dp, 1);
        int max = 0;
        pq.add(new int[] { 1, nums[0] });
        for (int i = 1; i < nums.length; i++) {
            List<int[]> temp = new ArrayList<>();
            while (!pq.isEmpty() && pq.peek()[1] >= nums[i]) {
                temp.add(pq.poll());
            }
            if (!pq.isEmpty()) {
                dp[i] = pq.peek()[0] + 1;
            }
            for (int[] o : temp) {
                pq.add(o);
            }
            pq.add(new int[] { dp[i], nums[i] });
            // System.out.println(i + " " + dp[i] + " " + nums[i]);
            max = Math.max(max, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return max;
    }
}