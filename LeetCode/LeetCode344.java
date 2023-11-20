/* 
 * 问题描述: https://leetcode.cn/problems/reverse-string/
 */

import java.util.Arrays;

public class LeetCode344 {
    public static void main(String[] args) {
        char[] s;
        // 输入：s = ["h","e","l","l","o"]
        // 输出：["o","l","l","e","h"]
        s = new char[] { 'h', 'e', 'l', 'l', 'o' };
        System.out.println(Arrays.toString(s));
        new Solution344().reverseString(s);
        System.out.println(Arrays.toString(s));

        // 输入：s = ["H","a","n","n","a","h"]
        // 输出：["h","a","n","n","a","H"]
        s = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
        System.out.println(Arrays.toString(s));
        new Solution344().reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}

class Solution344 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        char temp;
        while (i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}