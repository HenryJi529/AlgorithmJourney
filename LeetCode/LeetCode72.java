public class LeetCode72 {
    public static void main(String[] args) {
        // 输入：word1 = "horse", word2 = "ros"
        // 输出：3
        // System.out.println(new Solution72().minDistance("horse", "ros"));

        // 输入：word1 = "intention", word2 = "execution"
        // 输出：5
        // System.out.println(new Solution72().minDistance("intention", "execution"));

        // 输入：word1 = "", word2 = ""
        // 输出：0
        // System.out.println(new Solution72().minDistance("", ""));

        // 输入：word1 = "zoologicoarchaeologist", word2 = "zoogeologist"
        // 输出：10
        // "logicoarcha", "g"
        System.out.println(new Solution72().minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}

class Solution72 {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        int[][] dp = new int[word1.length()][word2.length()];
        // 初始化边缘
        int a = word1.indexOf(word2.charAt(0));
        int b = word2.indexOf(word1.charAt(0));
        // System.out.println(a + " " + b);
        for (int i = 0; i < word1.length(); i++) {
            if (a >= 0 && i >= a) {
                dp[i][0] = i;
            } else {
                dp[i][0] = i + 1;
            }
        }
        for (int j = 0; j < word2.length(); j++) {
            if (b >= 0 && j >= b) {
                dp[0][j] = j;
            } else {
                dp[0][j] = j + 1;
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[word1.length() - 1][word2.length() - 1];
    }
}