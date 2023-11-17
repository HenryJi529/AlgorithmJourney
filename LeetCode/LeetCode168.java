/* 
 * 问题描述: https://leetcode.cn/problems/excel-sheet-column-title/description/
 */

import java.util.Stack;

public class LeetCode168 {
    public static void main(String[] args) {
        // 输入：columnNumber = 1
        // 输出："A"
        // System.out.println(new Solution168().convertToTitle(1));

        // 输入：columnNumber = 28
        // 输出："AB"
        // System.out.println(new Solution168().convertToTitle(28));

        // 输入：columnNumber = 701
        // 输出："ZY"
        // System.out.println(new Solution168().convertToTitle(701));

        // 输入：columnNumber = 2147483647
        // 输出："FXSHRXW"
        // System.out.println(new Solution168().convertToTitle(2147483647));

        // 输入：columnNumber = 52
        // 输出："AZ"
        System.out.println(new Solution168().convertToTitle(52));
    }
}

class Solution168 {
    public String convertToTitle(int columnNumber) {
        Stack<Character> stack = new Stack<Character>();

        while (true) {
            int i = columnNumber % 26 != 0 ? columnNumber % 26 : 26;
            stack.push((char) ('A' + i - 1));
            if (columnNumber > 26) {
                columnNumber = (columnNumber - i) / 26;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}