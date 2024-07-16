import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode2390 {
    public static void main(String[] args) {
        // 输入：s = "leet**cod*e"
        // 输出："lecoe"
        System.out.println(new Solution2390().removeStars("leet**cod*e"));

        // 输入：s = "erase*****"
        // 输出：""
        // System.out.println(new Solution2390().removeStars("erase*****"));

    }
}

class Solution2390 {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}