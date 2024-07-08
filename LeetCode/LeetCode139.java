import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Comparator;

public class LeetCode139 {
    public static void main(String[] args) {
        // 输入: s = "leetcode", wordDict = ["leet", "code"]
        // 输出: true
        System.out.println(new Solution139().wordBreak("leetcode", List.of("leet",
                "code")));

        // 输入: s = "applepenapple", wordDict = ["apple", "pen"]
        // 输出: true
        System.out.println(new Solution139().wordBreak("applepenapple",
                List.of("apple", "pen")));

        // 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        // 输出: false
        System.out.println(new Solution139().wordBreak("catsandog", List.of("cats",
                "dog", "sand", "and", "cat")));

        // 输出: false
        System.out.println(new Solution139().wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
                        "aaaaaaaaa",
                        "aaaaaaaaaa")));
    }
}

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, HashSet<String>> dict = buildDict(wordDict);
        boolean[] dp = new boolean[s.length()];
        ArrayList<Integer> lens = new ArrayList<>(dict.keySet());
        // NOTE: 贪心(先匹配长的)
        lens.sort(Comparator.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
            for (int len : lens) {
                if (len == 1 + i) {
                    // 从头开始匹配
                    if (dict.get(len).contains(s.substring(0, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                } else if (len < 1 + i) {
                    if (dp[i - len] && dict.get(len).contains(s.substring(i - len + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    private HashMap<Integer, HashSet<String>> buildDict(List<String> wordDict) {
        HashMap<Integer, HashSet<String>> dict = new HashMap<Integer, HashSet<String>>();
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (!dict.containsKey(word.length())) {
                dict.put(word.length(), new HashSet<String>());
            }
            dict.get(word.length()).add(word);
        }
        return dict;
    }
}