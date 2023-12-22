import java.util.HashSet;
import java.util.HashMap;

public class LeetCode3 {
    public static void main(String[] args) {
        System.out.println(new Solution3_2().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3_2().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution3_2().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution3_2().lengthOfLongestSubstring("aabaab!bb"));
    }
}

class Solution3_1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int ans = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ans = Math.max(ans, set.size());
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
        }
        return Math.max(ans, set.size());
    }
}

class Solution3_2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
