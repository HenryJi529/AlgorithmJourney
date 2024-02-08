import java.util.HashMap;

public class LeetCode389 {
    public static void main(String[] args) {
        // 输入：s = "abcd", t = "abcde"
        // 输出："e"
        System.out.println(new Solution389_2().findTheDifference("abcd", "abcde"));

        // 输入：s = "", t = "y"
        // 输出："y"
        System.out.println(new Solution389_2().findTheDifference("", "y"));
    }
}

class Solution389_1 {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0) {
                return c;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return ' ';
    }
}

class Solution389_2 {
    // NOTE: 推荐数组，哈希表开销太大
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
}
