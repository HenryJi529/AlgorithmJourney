import java.util.Arrays;

public class LeetCode1235 {
    public static void main(String[] args) {
        // 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
        // 输出：120
        System.out.println(
                new Solution1235_2().jobScheduling(new int[] { 1, 2, 3, 3 }, new int[] { 3, 4, 5, 6 },
                        new int[] { 50, 10, 40, 70 }));

        // 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit =
        // [20,20,100,70,60]
        // 输出：150
        System.out.println(
                new Solution1235_2().jobScheduling(new int[] { 1, 2, 3, 4, 6 }, new int[] { 3, 5, 10, 6, 9 },
                        new int[] { 20, 20, 100, 70, 60 }));

        // 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
        // 输出：6
        System.out.println(
                new Solution1235_2().jobScheduling(new int[] { 1, 1, 1 }, new int[] { 2, 3, 4 },
                        new int[] { 5, 6, 4 }));
    }
}

class Solution1235_1 {
    // 此解法会超出内存限制，因为1 <= startTime[i] < endTime[i] <= 10^9
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        int MaxEndTime = 0;
        int MinEndTime = Integer.MAX_VALUE;
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];

            MinEndTime = Math.min(MinEndTime, endTime[i]);
            MaxEndTime = Math.max(MaxEndTime, endTime[i]);
        }
        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));
        // System.out.println(Arrays.deepToString(jobs));
        int[] dp = new int[MaxEndTime + 1];
        int fromIndex = 0;
        for (int i = MinEndTime; i <= MaxEndTime; i++) {
            dp[i] = dp[i - 1];
            for (int index = fromIndex; index < startTime.length; index++) {
                if (jobs[index][1] > i) {
                    fromIndex = index;
                    break;
                }
                dp[i] = Math.max(dp[i], jobs[index][2] + dp[jobs[index][0]]);
            }
        }
        return dp[MaxEndTime];
    }
}

class Solution1235_2 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));
        // System.out.println(Arrays.deepToString(jobs));
        int[] dp = new int[jobs.length + 1];
        for (int i = 1; i <= jobs.length; i++) {
            // 需要找到跟jobs[i-1]不冲突的最佳的jobs[j]: 满足jobs[j][1] <= jobs[i-1][0]的j的最大值
            int j = binarySearch(jobs, jobs[i - 1][0], i - 1);
            dp[i] = Math.max(dp[i - 1], dp[j] + jobs[i - 1][2]);
        }
        return dp[jobs.length];
    }

    public int binarySearch(int[][] jobs, int target, int right) {
        int left = 0;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}