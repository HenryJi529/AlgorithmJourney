/* 
 * 问题描述: https://leetcode.cn/problems/house-robber/description/
 */

import java.util.HashMap;

public class LeetCode198 {
    public static void main(String[] args) {
        // 输入：[1,2,3,1]
        // 输出：4
        System.out.println(new Solution().rob(new int[] { 1, 2, 3, 1 }));
        // 输入：[2,7,9,3,1]
        // 输出：12
        System.out.println(new Solution().rob(new int[] { 2, 7, 9, 3, 1 }));
    }
}

class Solution {
    private int[] money;
    private int N;
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int rob(int[] nums) {
        money = nums;
        N = nums.length;
        return rob(N - 1);
    }

    public int rob(int index) {
        if (index == 0) {
            return money[0];
        }
        if (index == 1) {
            return Math.max(money[0], money[1]);
        }
        if (index == 2) {
            return Math.max(money[0] + money[2], money[1]);
        }

        if (map.containsKey(index)) {
            return map.get(index);
        } else {
            int result = Math.max(rob(index - 1), rob(index - 2) + money[index]);
            map.put(index, result);
            return result;
        }
    }
}