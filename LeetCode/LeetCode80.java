/*
 * 问题描述: https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 */

import java.util.Arrays;

public class LeetCode80 {
    public static void main(String[] args) {
        int[] nums;
        int k;
        // 输入：nums = [1,1,1,2,2,3]
        // 输出：5, nums = [1,1,2,2,3]
        nums = new int[] { 1, 1, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(nums));
        k = new Solution80().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums) + " " + k);
        System.out.println("================================================");

        // 输入：nums = [0,0,1,1,1,1,2,3,3]
        // 输出：7, nums = [0,0,1,1,2,3,3]
        nums = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        System.out.println(Arrays.toString(nums));
        k = new Solution80().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums) + " " + k);
        System.out.println("================================================");
    }
}

class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 1;
        int j = 2;
        while (j < nums.length) {
            if (nums[j] == nums[i] && nums[j] == nums[i - 1]) {
            } else {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }
}