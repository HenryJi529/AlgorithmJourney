public class LeetCode1768 {
    public static void main(String[] args) {
        // 输入：word1 = "abc", word2 = "pqr"
        // 输出："apbqcr"
        System.out.println(new Solution1768().mergeAlternately("abc", "pqr"));

        // 输入：word1 = "ab", word2 = "pqrs"
        // 输出："apbqrs"
        System.out.println(new Solution1768().mergeAlternately("ab", "pqr"));

        // 输入：word1 = "abcd", word2 = "pq"
        // 输出："apbqcd"
        System.out.println(new Solution1768().mergeAlternately("abcd", "pq"));
    }
}

class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 != word1.length() || p2 != word2.length()) {
            if (p1 != word1.length()) {
                sb.append(word1.charAt(p1));
                p1++;
            }
            if (p2 != word2.length()) {
                sb.append(word2.charAt(p2));
                p2++;
            }
        }
        return sb.toString();
    }
}