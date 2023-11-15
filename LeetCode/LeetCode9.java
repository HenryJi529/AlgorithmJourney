/* 
 * 问题描述: https://leetcode.cn/problems/palindrome-number/description/
 * 解题思路: 栈堆同存后同出/双指针/递归
 */

public class LeetCode9 {
    public static void main(String[] args) {
        // 输入：x = 121
        // 输出：true
        System.out.println(new Solution9().isPalindrome(121));

        // 输入：x = -121
        // 输出：false
        System.out.println(new Solution9().isPalindrome(-121));

        // 输入：x = 10
        // 输出：false
        System.out.println(new Solution9().isPalindrome(10));
    }
}

class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);

        return isPalindrome(s, 0, s.length() - 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        int length = end - start;
        if (length <= 0) {
            return true;
        } else {
            if (s.charAt(start) == s.charAt(end)) {
                return isPalindrome(s, start + 1, end - 1);
            } else {
                return false;
            }
        }
    }
}
