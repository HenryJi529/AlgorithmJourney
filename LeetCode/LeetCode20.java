import java.util.Stack;
import java.util.HashMap;

public class LeetCode20 {
    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("()"));
        System.out.println(new Solution20().isValid("()[]{}"));
        System.out.println(new Solution20().isValid("(]"));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (dict.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != dict.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
