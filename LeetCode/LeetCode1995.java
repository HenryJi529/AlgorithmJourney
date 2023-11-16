public class LeetCode1995 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3,6]
        // 输出：1
        // 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
        System.out.println(new Solution1995().countQuadruplets(new int[] { 1, 2, 3, 6 }));

        // 输入：nums = [3,3,6,4,5]
        // 输出：0
        // 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
        System.out.println(new Solution1995().countQuadruplets(new int[] { 3, 3, 6, 4, 5 }));

        // 输入：nums = [1,1,1,3,5]
        // 输出：4
        // 解释：满足要求的 4 个四元组如下：
        // - (0, 1, 2, 3): 1 + 1 + 1 == 3
        // - (0, 1, 3, 4): 1 + 1 + 3 == 5
        // - (0, 2, 3, 4): 1 + 1 + 3 == 5
        // - (1, 2, 3, 4): 1 + 1 + 3 == 5
        System.out.println(new Solution1995().countQuadruplets(new int[] { 1, 1, 1, 3, 5 }));
    }
}

class Solution1995 {
    public int countQuadruplets(int[] nums) {
        if (nums.length < 4) {
            return 0;
        }
        int count = 0;
        for (int v = nums.length - 1; v >= 3; v--) {
            for (int k = v - 1; k >= 2; k--) {
                if (nums[k] > nums[v] - 2) {
                    continue;
                }
                for (int j = k - 1; j >= 1; j--) {
                    if (nums[j] + nums[k] > nums[v] - 1) {
                        continue;
                    }
                    for (int i = j - 1; i >= 0; i--) {
                        if (nums[i] + nums[j] + nums[k] == nums[v]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
