/*
 * 问题描述: https://leetcode.cn/problems/remove-element/description/
 * 解题思路: 双指针(用反向更好，避免重复赋值)
 */

public class LeetCode27 {
    public static void main(String[] args) {
        int len;
        int[] nums;
        int val;
        // 输入：nums = [3,2,2,3], val = 3
        // 输出：2, nums = [2,2]
        nums = new int[] { 3, 2, 2, 3 };
        val = 3;
        len = new Solution27().removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
        System.out.println("\n================================================");

        // 输入：nums = [0,1,2,2,3,0,4,2], val = 2
        // 输出：5, nums = [0,1,3,0,4]
        nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        val = 2;
        len = new Solution27().removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
        System.out.println("\n================================================");
    }
}

class Solution27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}