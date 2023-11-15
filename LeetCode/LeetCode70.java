/*
 * 问题描述: https://leetcode.cn/problems/climbing-stairs/description/
 */

import java.util.HashMap;

public class LeetCode70 {
    public static void main(String[] args) {
        // 输入：n = 2
        // 输出：2
        System.out.println(new Solution().climbStairs(2));
        // 输入：n = 3
        // 输出：3
        System.out.println(new Solution().climbStairs(3));
    }
}

class Solution {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, result);
            return result;
        }
    }
}