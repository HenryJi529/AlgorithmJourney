/* 
 * 问题描述: https://leetcode.cn/problems/move-zeroes/
 */

import java.util.Arrays;

public class LeetCode283 {
    public static void main(String[] args) {
        int[] nums;
        // 输入: nums = [0,1,0,3,12]
        // 输出: [1,3,12,0,0]
        nums = new int[] { 0, 1, 0, 3, 12 };
        System.out.println(Arrays.toString(nums));
        new Solution283_2().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        // 输入: nums = [0]
        // 输出: [0]
        nums = new int[] { 0 };
        System.out.println(Arrays.toString(nums));
        new Solution283_2().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution283_1 {
    public void moveZeroes(int[] nums) {
        int i = -1;
        int j = 0;
        int temp;
        while (j < nums.length) {
            if (nums[j] != 0) {
                i++;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            j++;
        }
    }
}

class Solution283_2 {
    public void moveZeroes(int[] nums) {
        int i = -1;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        i++;
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}