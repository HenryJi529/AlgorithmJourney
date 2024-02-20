public class LeetCode268 {
    public static void main(String[] args) {
        // 输入：nums = [3,0,1]
        // 输出：2
        System.out.println(new Solution268().missingNumber(new int[] { 3, 0, 1 }));

        // 输入：nums = [0,1]
        // 输出：2
        System.out.println(new Solution268().missingNumber(new int[] { 0, 1 }));

        // 输入：nums = [9,6,4,2,3,5,7,0,1]
        // 输出：8
        System.out.println(new Solution268().missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));

        // 输入：nums = [0]
        // 输出：1
        System.out.println(new Solution268().missingNumber(new int[] { 0 }));
    }
}

class Solution268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}