import java.util.Arrays;

public class LeetCode1005 {
    public static void main(String[] args) {
        // 输入：nums = [4,2,3], k = 1
        // 输出：5
        System.out.println(new Solution1005().largestSumAfterKNegations(new int[] { 4, 2, 3 }, 1));

        // 输入：nums = [3,-1,0,2], k = 3
        // 输出：6
        System.out.println(new Solution1005().largestSumAfterKNegations(new int[] { 3, -1, 0, 2 }, 3));

        // 输入：nums = [2,-3,-1,5,-4], k = 2
        // 输出：13
        System.out.println(new Solution1005().largestSumAfterKNegations(new int[] { 2, -3, -1, 5, -4 }, 2));

        // 输入：nums = [-4,-2,-3], k = 4
        // 输出：
        System.out.println(new Solution1005().largestSumAfterKNegations(new int[] { -4, -2, -3 }, 4));
    }
}

class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int ans = 0;
        int ind = 0;
        while (k > 0) {
            if (ind == nums.length) {
                if (k % 2 == 1) {
                    ans += 2 * nums[nums.length - 1];
                }
                break;
            }
            if (nums[ind] < 0) {
                ans -= nums[ind];
                ind++;
            } else {
                if (k % 2 == 1) {
                    if (ind - 1 >= 0 && nums[ind] >= -nums[ind - 1]) {
                        ans += 2 * nums[ind - 1];
                        ans += nums[ind];
                    } else {
                        ans -= nums[ind];
                    }
                } else {
                    ans += nums[ind];
                }
                ind++;
                break;
            }
            k--;
        }

        for (int i = ind; i < nums.length; i++) {
            ans += nums[i];
        }
        return ans;
    }
}