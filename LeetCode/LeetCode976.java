import java.util.Arrays;

public class LeetCode976 {
    public static void main(String[] args) {
        // 输入：nums = [2,1,2]
        // 输出：5
        System.out.println(new Solution976().largestPerimeter(new int[] { 2, 1, 2 }));

        // 输入：nums = [1,2,1,10]
        // 输出：0
        System.out.println(new Solution976().largestPerimeter(new int[] { 1, 2, 1, 10 }));
    }
}

class Solution976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}