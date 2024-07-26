public class LeetCode392 {
    public static void main(String[] args) {
        // 输入：s = "abc", t = "ahbgdc"
        // 输出：true
        System.out.println(new Solution392().isSubsequence("abc", "ahbgdc"));

        // 输入：s = "axc", t = "ahbgdc"
        // 输出：false
        System.out.println(new Solution392().isSubsequence("axc", "ahbgdc"));
    }
}

class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == s.length();
    }
}