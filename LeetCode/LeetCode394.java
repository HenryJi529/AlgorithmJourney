import java.util.Deque;
import java.util.LinkedList;

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

/**
 * 解析数字与字符串、字符串解码分两步进行
 */
class Solution394 {
    public String decodeString(String s) {
        // 遍历所有元素，将数据拆分
        Deque<String> strs = new LinkedList<>();
        StringBuilder sb_num = new StringBuilder();
        StringBuilder sb_str = new StringBuilder();

        for (Character c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (sb_str.length() > 0) {
                    strs.offer(sb_str.toString());
                    sb_str = new StringBuilder();
                }
                sb_num.append(c);
            } else if (c == '[') {
                strs.offer(sb_num.toString());
                sb_num = new StringBuilder();
                strs.offer("[");
            } else if (c == ']') {
                if (sb_str.length() > 0) {
                    strs.offer(sb_str.toString());
                    sb_str = new StringBuilder();
                }
                strs.offer("]");
            } else {
                sb_str.append(c);
            }
        }
        if (sb_str.length() > 0) {
            strs.offer(sb_str.toString());
        }
        // System.out.println(strs);

        // 组合乘数和被乘的字符串
        Deque<String> stack = new LinkedList<>();
        while (!strs.isEmpty()) {
            String str = strs.poll();
            if (str == "]") {
                StringBuilder curr = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != "[") {
                    curr.insert(0, stack.pop());
                }
                if (stack.isEmpty()) {
                    // 没有乘数
                    stack.push(curr.toString());
                } else {
                    stack.pop(); // 弹出"["
                    int multi = Integer.parseInt(stack.pop());
                    StringBuilder sb = new StringBuilder();
                    while (multi > 0) {
                        sb.append(curr.toString());
                        multi--;
                    }
                    stack.push(sb.toString());
                }
            } else {
                stack.push(str);
            }
        }
        // System.out.println(stack);

        // 生成最终结果
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
