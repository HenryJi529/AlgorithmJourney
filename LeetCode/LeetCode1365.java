import java.util.Arrays;

public class LeetCode1365 {
    public static void main(String[] args) {
        // 输入：nums = [8,1,2,2,3]
        // 输出：[4,0,1,1,3]
        System.out.println(Arrays.toString(new Solution1365().smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 })));

        // 输入：nums = [6,5,4,8]
        // 输出：[2,1,0,3]
        System.out.println(Arrays.toString(new Solution1365().smallerNumbersThanCurrent(new int[] { 6, 5, 4, 8 })));

        // 输入：nums = [7,7,7,7]
        // 输出：[0,0,0,0]
        System.out.println(Arrays.toString(new Solution1365().smallerNumbersThanCurrent(new int[] { 7, 7, 7, 7 })));

    }
}

class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            // 这一步可以用一个累加来做 count[i+1] = count[i] + count[i+1]
            for (int value = 0; value < nums[i]; value++) {
                sum += counts[value];
            }
            nums[i] = sum;
        }

        return nums;
    }
}