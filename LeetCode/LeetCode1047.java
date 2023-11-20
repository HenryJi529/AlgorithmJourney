/*
 * 问题描述: https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/
 */

public class LeetCode1047 {
    public static void main(String[] args) {
        String S1, S2;
        // 输入："abbaca"
        // 输出："ca"
        S1 = "abbaca";
        System.out.println(S1);
        S2 = new Solution1047().removeDuplicates(S1);
        System.out.println(S2);
    }
}

class Solution1047 {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        int length = s.length();
        stack.append(s.charAt(0));
        for (int i = 1; i < length; i++) {
            if (!stack.isEmpty() && stack.charAt(stack.length() - 1) == s.charAt(i)) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(s.charAt(i));
            }
        }
        return stack.toString();
    }
}
