/* 
 * 问题描述: https://leetcode.cn/problems/contains-duplicate-ii/description/
 * 解题思路: 双指针迭代, 滑动窗口(HashSet)
 */

import java.util.HashSet;

public class LeetCode219 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1], k = 3
        // 输出：true
        System.out.println(new Solution219_2().containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));

        // 输入：nums = [1,0,1,1], k = 1
        // 输出：true
        System.out.println(new Solution219_2().containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));

        // 输入：nums = [1,2,3,1,2,3], k = 2
        // 输出：false
        System.out.println(new Solution219_2().containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));

    }
}

class Solution219_1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        if (nums.length < 2) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (true) {
            j++;
            if (j - i > k || j == nums.length) {
                i++;
                j = i + 1;
                if (j == nums.length) {
                    break;
                }
            }
            if (nums[i] == nums[j]) {
                return true;
            }
        }
        return false;
    }
}

class Solution219_2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
