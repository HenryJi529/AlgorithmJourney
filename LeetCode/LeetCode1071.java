public class LeetCode1071 {
    public static void main(String[] args) {
        // 输入：str1 = "ABCABC", str2 = "ABC"
        // 输出："ABC"
        System.out.println(new Solution1071().gcdOfStrings("ABCABC", "ABC"));

        // 输入：str1 = "ABABAB", str2 = "ABAB"
        // 输出："AB"
        System.out.println(new Solution1071().gcdOfStrings("ABABAB", "ABAB"));

        // 输入：str1 = "LEET", str2 = "CODE"
        // 输出：""
        System.out.println(new Solution1071().gcdOfStrings("LEET", "CODE"));
    }
}

class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        int gcd = getGCD(str1.length(), str2.length());
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        for (int len = gcd; len > 0; len--) {
            if (str1.length() % len != 0 || str2.length() % len != 0) {
                continue;
            }
            if (check(s1, s2, len)) {
                return str1.substring(0, len);
            }
        }
        return "";
    }

    public int getGCD(int len1, int len2) {
        int temp;
        while (true) {
            len1 = len1 >= len2 ? len1 : len2;
            len2 = len1 < len2 ? len1 : len2;
            if (len1 % len2 == 0) {
                return len2;
            }
            temp = len1;
            len1 = len2;
            len2 = temp % len2;
        }
    }

    public boolean check(char[] s1, char[] s2, int len) {
        for (int i = 0; i < len; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        for (int i = len; i < s1.length; i++) {
            if (s1[i] != s1[i % len]) {
                return false;
            }
        }
        for (int i = len; i < s2.length; i++) {
            if (s2[i] != s2[i % len]) {
                return false;
            }
        }
        return true;
    }
}