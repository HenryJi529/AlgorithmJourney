public class LeetCode151 {
    public static void main(String[] args) {
        // 输入：s = "the sky is blue"
        // 输出："blue is sky the"
        System.out.println(new Solution151().reverseWords("the sky is blue"));

        // 输入：s = " hello world "
        // 输出："world hello"
        System.out.println(new Solution151().reverseWords(" hello world "));

        // 输入：s = "a good example"
        // 输出："example good a"
        System.out.println(new Solution151().reverseWords("a good example"));
    }
}

class Solution151 {
    public String reverseWords(String s) {
        s = new StringBuilder(s.strip()).reverse().toString();
        // System.out.println(s);
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while (p < s.length()) {
            char c = s.charAt(p);
            if (c == ' ') {
                if (sb.length() > 0) {
                    result.append(sb.reverse());
                    result.append(' ');
                }
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
            p++;
        }
        sb.reverse();
        result.append(sb.toString());
        return result.toString();
    }
}