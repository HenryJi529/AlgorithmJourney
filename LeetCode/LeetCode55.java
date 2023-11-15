/* 
 * 问题描述: https://leetcode.cn/problems/jump-game/description/
 * 解题思路: 其实不用动态规划，直接使用贪心算法更新最远位置就行
 */

public class LeetCode55 {
    public static void main(String[] args) {
        // 输入：nums = [2,3,1,1,4]
        // 输出：true
        System.out.println(new Solution().canJump(new int[] { 2, 3, 1, 1, 4 }));

        // 输入：nums = [3,2,1,0,4]
        // 输出：false
        System.out.println(new Solution().canJump(new int[] { 3, 2, 1, 0, 4 }));

        // 输入: nums =
        // [2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6]
        System.out.println(new Solution().canJump(new int[] { 2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3,
                1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9,
                3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1,
                5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6 }));
    }

}

class Solution {
    private int[] nums;
    private int[] record; // 元素为-1，代表无法访问；元素为1，代表可以访问；元素为0，代表还未访问

    public boolean canJump(int[] nums) {
        this.nums = nums;
        this.record = new int[nums.length];
        this.record[0] = 1;
        return canJump(nums.length - 1);
    }

    public boolean canJump(int index) {
        if (record[index] == 1) {
            return true;
        }
        for (int i = index - 1; i >= 0; i--) {
            if (record[i] == 1 || (this.record[i] == 0 && canJump(i) == true)) {
                if (nums[i] + i >= index) {
                    record[index] = 1;
                    return true;
                }
            }
        }
        this.record[index] = -1;
        return false;
    }
}