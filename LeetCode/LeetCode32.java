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
    // NOTE: 暴力解法，部分超时
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        for (int length = s.length() % 2 == 0 ? s.length() : s.length() - 1; length >= 2; length -= 2) {
            for (int i = 0; i + length <= s.length(); i++) {
                if (isValidParentheses(s, i, i + length - 1)) {
                    return length;
                }
            }
        }

        return 0;
    }

    public boolean isValidParentheses(String s, int start, int end) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

class Solution32_2 {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        for (int end = 1; end < s.length(); end++) {
            if (s.charAt(end) == '(') {
                continue;
            }
            if (s.charAt(end - 1) == '(') {
                dp[end] = end - 2 >= 0 ? dp[end - 2] + 2 : 2;
            } else {
                int ind = end - 1 - dp[end - 1];
                if (ind >= 0 && s.charAt(ind) == '(') {
                    dp[end] = dp[end - 1] + 2 + (ind - 1 >= 0 ? dp[ind - 1] : 0);
                }
            }
            // System.out.println(end + " " + dp[end]);
            max = Math.max(max, dp[end]);
        }
        return max;
    }

}