import java.util.Arrays;

public class LeetCode1657 {
    public static void main(String[] args) {
        // 输入：word1 = "abc", word2 = "bca"
        // 输出：true
        // 解释：2 次操作从 word1 获得 word2 。
        // 执行操作 1："abc" -> "acb"
        // 执行操作 1："acb" -> "bca"
        System.out.println(new Solution1657().closeStrings("abc", "bca"));

        // 输入：word1 = "a", word2 = "aa"
        // 输出：false
        // 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
        System.out.println(new Solution1657().closeStrings("a", "aa"));

        // 输入：word1 = "cabbba", word2 = "abbccc"
        // 输出：true
        // 解释：3 次操作从 word1 获得 word2 。
        // 执行操作 1："cabbba" -> "caabbb"
        // 执行操作 2："caabbb" -> "baaccc"
        // 执行操作 2："baaccc" -> "abbccc"
        System.out.println(new Solution1657().closeStrings("cabbba", "abbccc"));

        // 输入：word1 = "uau", word2 = "ssx"
        // 输出：true
        System.out.println(new Solution1657().closeStrings("uau", "ssx"));
    }
}

class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            counts1[word1.charAt(i) - 'a']++;
            counts2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] + counts2[i] > 0 && counts1[i] * counts2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(counts1);
        Arrays.sort(counts2);
        // System.out.println(Arrays.toString(counts1));
        // System.out.println(Arrays.toString(counts2));
        return Arrays.compare(counts1, counts2) == 0;
    }
}