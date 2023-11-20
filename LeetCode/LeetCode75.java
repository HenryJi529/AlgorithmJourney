/*
 * 问题描述: https://leetcode.cn/problems/sort-colors/description/
 */

import java.util.Arrays;

public class LeetCode75 {
    public static void main(String[] args) {
        int[] nums;
        // 输入：nums = [2,0,2,1,1,0]
        // 输出：[0,0,1,1,2,2]
        nums = new int[] { 2, 0, 2, 1, 1, 0 };
        System.out.println(Arrays.toString(nums));
        new Solution75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("================================================================");

        // 输入：nums = [2,0,1]
        // 输出：[0,1,2]
        nums = new int[] { 2, 0, 1 };
        System.out.println(Arrays.toString(nums));
        new Solution75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("================================================================");

        // 输入：nums = [1,2,0]
        // 输出：[0,1,2]
        nums = new int[] { 1, 2, 0 };
        System.out.println(Arrays.toString(nums));
        new Solution75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("================================================================");
    }
}

class Solution75 {
    public void sortColors(int[] nums) {
        int slow = -1;
        int fast = nums.length;
        int i = 0;
        while (i < fast && i < nums.length) {
            if (nums[i] == 0) {
                slow++;
                nums[i] = nums[slow];
                nums[slow] = 0;
                i++;
            } else if (nums[i] == 2) {
                fast--;
                nums[i] = nums[fast];
                nums[fast] = 2;
            } else {
                i++;
            }
        }
    }
}