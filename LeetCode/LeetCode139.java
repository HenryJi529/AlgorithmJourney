import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Comparator;

public class LeetCode139 {
    public static void main(String[] args) {
        // 输入: s = "leetcode", wordDict = ["leet", "code"]
        // 输出: true
        System.out.println(new Solution139_2().wordBreak("leetcode", List.of("leet",
                "code")));

        // 输入: s = "applepenapple", wordDict = ["apple", "pen"]
        // 输出: true
        System.out.println(new Solution139_2().wordBreak("applepenapple",
                List.of("apple", "pen")));

        // 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        // 输出: false
        System.out.println(new Solution139_2().wordBreak("catsandog", List.of("cats",
                "dog", "sand", "and", "cat")));

        // 输出: false
        System.out.println(new Solution139_2().wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                        "aaaaaaaaaa")));
    }
}

class Solution139_1 {
    // NOTE: 时间复杂度过高，因为records不够直接
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, HashSet<String>> dict = new HashMap<Integer, HashSet<String>>();
        HashSet<Integer> records = new HashSet<>(); // [i,N-1] 被分走
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (!dict.containsKey(word.length())) {
                dict.put(word.length(), new HashSet<String>());
            }
            dict.get(word.length()).add(word);
        }
        ArrayList<Integer> wordLengths = new ArrayList<>(dict.keySet());
        wordLengths.sort(Comparator.reverseOrder());

        return dp(s.length(), s, dict, wordLengths, records);
    }

    public boolean dp(int n, String s, HashMap<Integer, HashSet<String>> dict, ArrayList<Integer> wordLengths,
            HashSet<Integer> records) {
        if (n == 0) {
            return true;
        }
        for (int wordLength : wordLengths) {
            if (n - wordLength < 0) {
                continue;
            }
            String substr = s.substring(n - wordLength, n);
            if (records.contains(n - wordLength)) {
                if (dp(n - wordLength, s, dict, wordLengths, records)) {
                    return true;
                }
            } else if (dict.get(wordLength).contains(substr)) {
                records.add(n - wordLength);
                if (dp(n - wordLength, s, dict, wordLengths, records)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution139_2 {
    // NOTE: 此版本不仅存对了records，还用贪心算法加速计算(有助于找到true)
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, HashSet<String>> dict = new HashMap<Integer, HashSet<String>>();
        HashMap<Integer, Boolean> records = new HashMap<>();// [0-i)被分走
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (!dict.containsKey(word.length())) {
                dict.put(word.length(), new HashSet<String>());
            }
            dict.get(word.length()).add(word);
        }
        ArrayList<Integer> wordLengths = new ArrayList<>(dict.keySet());
        wordLengths.sort(Comparator.reverseOrder());
        records.put(0, true);
        return dp(s.length(), s, dict, wordLengths, records);
    }

    public boolean dp(int n, String s, HashMap<Integer, HashSet<String>> dict, ArrayList<Integer> wordLengths,
            HashMap<Integer, Boolean> records) {
        if (records.containsKey(n)) {
            return records.get(n);
        }

        for (int wordLength : wordLengths) {
            if (n - wordLength < 0) {
                continue;
            }
            if ((!records.containsKey(n - wordLength) && dp(n - wordLength, s, dict, wordLengths, records)
                    || records.get(n - wordLength))) {
                String substr = s.substring(n - wordLength, n);
                if (dict.get(wordLength).contains(substr)) {
                    records.put(n, true);
                    return true;
                }
            }
        }
        records.put(n, false);
        return false;
    }
}
