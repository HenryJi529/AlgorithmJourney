public class LeetCode242 {
    public static void main(String[] args) {
        // 输入: s = "anagram", t = "nagaram"
        // 输出: true
        System.out.println(new Solution242().isAnagram("anagram", "nagaram"));

        // 输入: s = "rat", t = "car"
        // 输出: false
        System.out.println(new Solution242().isAnagram("rat", "car"));

    }
}

class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
            if (counts[t.charAt(i) - 'a'] == -1) {
                return false;
            }
        }
        return true;
    }
}
