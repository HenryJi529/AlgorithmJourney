/*
 * 问题描述: https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 * 解题思路: LinkedHashSet, 双指针
 */

import java.util.Arrays;

public class LeetCode26 {

    public static void main(String[] args) {
        int[] nums;
        int[] expected;
        int N;
        // 输入：nums = [1,1,2]
        // 输出：2, nums = [1,2,_]
        nums = new int[] { 1, 1, 2 };
        expected = new int[] { 1, 2 };
        // test(nums, expected);
        N = new Solution26().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums) + " " + N);
        System.out.println(Arrays.toString(expected));

        // 输入：nums = [0,0,1,1,1,2,2,3,3,4]
        // 输出：5, nums = [0,1,2,3,4]
        nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        expected = new int[] { 0, 1, 2, 3, 4 };
        // test(nums, expected);
        N = new Solution26().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums) + " " + N);
        System.out.println(Arrays.toString(expected));
    }

    public static void test(int[] nums, int[] expected) {
        int k = new Solution26().removeDuplicates(nums); // 调用

        assert k == expected.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expected[i];
        }
    }
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                fast++;
                slow++;
            } else {
                fast++;
            }
        }
        return slow + 1;
    }
}