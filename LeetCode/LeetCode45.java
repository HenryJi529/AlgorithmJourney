
public class LeetCode45 {
    public static void main(String[] args) {
        // 输入: nums = [2,3,1,1,4]
        // 输出: 2
        // System.out.println(new Solution45_3().jump(new int[] { 2, 3, 1, 1, 4 }));

        // 输入: nums = [2,3,0,1,4]
        // 输出: 2
        // System.out.println(new Solution45_3().jump(new int[] { 2, 3, 0, 1, 4 }));

        // 输入: nums = [1,2]
        // 输出: 1
        // System.out.println(new Solution45_3().jump(new int[] { 1, 2 }));

        // 输入: nums = [1,1,1,1]
        // 输出: 3
        System.out.println(new Solution45_3().jump(new int[] { 1, 1, 1, 1 }));
    }
}

/**
 * 迭代: 状态设置为从0开始跳到每个点需要的步数
 */
class Solution45_1 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1 + i; j <= Math.min(nums[i] + i, nums.length - 1); j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}

/**
 * DP: 状态设置为每个点跳到n-1需要的步数
 */
class Solution45_2 {
    private int[] dp;

    public int jump(int[] nums) {
        dp = new int[nums.length];
        return getStep(0, nums);
    }

    public int getStep(int start, int[] nums) {
        if (start >= nums.length - 1) {
            return 0;
        } else if (start + nums[start] >= nums.length - 1) {
            return 1;
        } else {
            if (dp[start] != 0) {
                return dp[start];
            }
            int steps = nums.length - 1;
            for (int i = 1; i <= nums[start]; i++) {
                steps = Math.min(getStep(start + i, nums) + 1, steps);
            }
            dp[start] = steps;
            return steps;
        }
    }
}

/**
 * 维护最远可以到达的位置以及每个步数可以到达的位置
 */
class Solution45_3 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 1;
        int furthest = nums[0];
        if (furthest >= nums.length - 1) {
            return step;
        }
        int ind = 0;
        int stepFurthest = furthest;
        while (true) {
            if (ind <= stepFurthest) {
                furthest = Math.max(furthest, nums[ind] + ind);
                if (furthest >= nums.length - 1) {
                    return step + 1;
                }
                ind++;
            } else {
                step++;
                stepFurthest = furthest;
            }
        }

    }
}