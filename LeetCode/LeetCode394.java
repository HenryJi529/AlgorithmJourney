import java.util.Deque;
import java.util.ArrayDeque;

public class LeetCode394 {
    public static void main(String[] args) {
        // 输入：s = "3[a]2[bc]"
        // 输出："aaabcbc"
        System.out.println(new Solution394().decodeString("3[a]2[bc]"));

        // 输入：s = "3[a2[c]]"
        // 输出："accaccacc"
        System.out.println(new Solution394().decodeString("3[a2[c]]"));

        // 输入：s = "2[abc]3[cd]ef"
        // 输出："abcabccdcdcdef"
        System.out.println(new Solution394().decodeString("2[abc]3[cd]ef"));

        // 输入：s = "abc3[cd]xyz"
        // 输出："abccdcdcdxyz"
        System.out.println(new Solution394().decodeString("abc3[cd]xyz"));

        // 输入：s = "100[leetcode]"
        // 输出：...
        System.out.println(new Solution394().decodeString("100[leetcode]"));
    }
}

class Solution394 {
    public String decodeString(String s) {
        StringBuilder sb;
        int num;
        int rank;
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                sb.reverse();
                stack.pop();

                // 获取重复次数
                num = 0;
                rank = 1;
                while (!stack.isEmpty() && (stack.peek() >= '0' && stack.peek() <= '9')) {
                    num += rank * (int) (stack.pop() - '0');
                    rank *= 10;
                }

                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < sb.length(); k++) {
                        stack.push(sb.charAt(k));
                    }
                }
            } else {
                stack.push(c);
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
