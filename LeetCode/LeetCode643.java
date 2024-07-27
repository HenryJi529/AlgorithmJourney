public class LeetCode643 {
    public static void main(String[] args) {
        // 输入：nums = [1,12,-5,-6,50,3], k = 4
        // 输出：12.75
        System.out.println(new Solution643().findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));

        // 输入：nums = [5], k = 1
        // 输出：5.00000
        System.out.println(new Solution643().findMaxAverage(new int[] { 5 }, 1));
    }
}

class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int ans = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            ans = Math.max(ans, sum);
        }
        return ans * 1.0 / k;
    }
}