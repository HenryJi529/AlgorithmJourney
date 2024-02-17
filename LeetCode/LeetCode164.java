import java.util.Arrays;

public class LeetCode164 {
    public static void main(String[] args) {
        // 输入: nums = [3,6,9,1]
        // 输出: 3
        System.out.println(new Solution164().maximumGap(new int[] { 3, 6, 9, 1 }));

        // 输入: nums = [10]
        // 输出: 0
        System.out.println(new Solution164().maximumGap(new int[] { 10 }));
    }
}

class Solution164 {
    // NOTE: 使用内置的sort也行
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.max(ans, nums[i + 1] - nums[i]);
        }
        return ans;
    }
}
