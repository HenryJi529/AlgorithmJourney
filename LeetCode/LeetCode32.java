/* 
 * 问题描述: https://leetcode.cn/problems/longest-valid-parentheses/description/
 * 解题思路: 动态规划，考虑`(`与`)`对应关系
 */

import java.util.Stack;

public class LeetCode32 {

    public static void main(String[] args) {
        // 输入：s = "(()"
        // 输出：2
        System.out.println(new Solution32_2().longestValidParentheses("(()"));

        // 输入：s = ")()())"
        // 输出：4
        System.out.println(new Solution32_2().longestValidParentheses(")()())"));

        // 输入：s = ""
        // 输出：0
        System.out.println(new Solution32_2().longestValidParentheses(""));

        // 输入：s = "()()"
        // 输出：4
        System.out.println(new Solution32_2().longestValidParentheses("()()"));

        // 输入：s = "()(())"
        // 输出：6
        System.out.println(new Solution32_2().longestValidParentheses("()(())"));
    }
}

class Solution32_1 {
    private Stack<Character> stack = new Stack<Character>();

    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int start = 0; start < s.length() - 1; start++) {
            for (int end = start; end < s.length(); end++) {
                int count = longestValidParentheses(s, start, end);
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }

    private int longestValidParentheses(String s, int start, int end) {
        stack.clear();

        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return end - start + 1;
        } else {
            return 0;
        }
    }
}

class Solution32_2 {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
        }
        return max;
    }
}