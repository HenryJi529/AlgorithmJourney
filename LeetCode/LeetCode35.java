/* 
 * 问题描述: https://leetcode.cn/problems/search-insert-position/
 */

public class LeetCode35 {

    public static void main(String[] args) {
        // 输入: nums = [1,3,5,6], target = 5
        // 输出: 2
        System.out.println(new Solution35().searchInsert(new int[] { 1, 3, 5, 6 }, 5));

        // 输入: nums = [1,3,5,6], target = 2
        // 输出: 1
        System.out.println(new Solution35().searchInsert(new int[] { 1, 3, 5, 6 }, 2));

        // 输入: nums = [1,3,5,6], target = 7
        // 输出: 4
        System.out.println(new Solution35().searchInsert(new int[] { 1, 3, 5, 6 }, 7));
    }

}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            System.out.println(String.format("l: %d r: %d mid: %d(%d)", l, r, mid, nums[mid]));
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}