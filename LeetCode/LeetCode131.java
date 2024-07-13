import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

public class LeetCode131 {
    public static void main(String[] args) {
        // 输入：s = "aab"
        // 输出：[["a","a","b"],["aa","b"]]
        PrintUtil.printNestedList(new Solution131().partition("aab"));

        // 输入：s = "a"
        // 输出：[["a"]]
        PrintUtil.printNestedList(new Solution131().partition("a"));
    }
}

class Solution131 {
    Boolean[][] dp;
    List<List<String>> solutions = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {

        dp = new Boolean[s.length()][s.length()];
        // 先填奇数字表
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = 1; j < s.length(); j++) {
                if (i - j >= 0 && i + j < s.length()) {
                    dp[i - j][i + j] = dp[i - j + 1][i + j - 1] ? s.charAt(i - j) == s.charAt(i + j) : false;
                }
            }
        }
        // 再填偶数表
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            for (int j = 1; j < s.length(); j++) {
                if (i - j >= 0 && i + j + 1 < s.length()) {
                    dp[i - j][i + j + 1] = dp[i - j + 1][i + j] ? s.charAt(i - j) == s.charAt(i + j + 1) : false;
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        for (int i = 0; i < dp.length; i++) {
            if (dp[0][i]) {
                dfs(s, i + 1, new ArrayList<String>(List.of(s.substring(0, i + 1))));
            }
        }
        return solutions;
    }

    public void dfs(String s, int ind, List<String> solution) {
        if (ind == s.length()) {
            solutions.add(new ArrayList<>(solution));
        }
        for (int i = ind; i < s.length(); i++) {
            if (dp[ind][i]) {
                solution.add(s.substring(ind, i + 1));
                dfs(s, i + 1, solution);
                solution.removeLast();
            }
        }
    }

}