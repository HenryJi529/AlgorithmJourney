/* 
 * 问题描述: https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/
 */

import java.util.Stack;

public class LeetCode150 {
    public static void main(String[] args) {
        String[] tokens1 = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(new Solution().evalRPN(tokens1));

        String[] tokens2 = new String[] { "4", "13", "5", "/", "+" };
        System.out.println(new Solution().evalRPN(tokens2));

        String[] tokens3 = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(new Solution().evalRPN(tokens3));
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                Integer secondInt = stack.pop();
                Integer firstInt = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(firstInt + secondInt);
                        break;
                    case "-":
                        stack.push(firstInt - secondInt);
                        break;
                    case "*":
                        stack.push(firstInt * secondInt);
                        break;
                    case "/":
                        stack.push(firstInt / secondInt);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}