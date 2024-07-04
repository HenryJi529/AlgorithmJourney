public class LeetCode76 {
    public static void main(String[] args) {
        // 输入：s = "ADOBECODEBANC", t = "ABC"
        // 输出："BANC"
        System.out.println(new Solution76_2().minWindow("ADOBECODEBANC", "ABC"));

        // 输入：s = "a", t = "a"
        // 输出："a"
        System.out.println(new Solution76_2().minWindow("a", "a"));

        // 输入: s = "a", t = "aa"
        // 输出: ""
        System.out.println(new Solution76_2().minWindow("a", "aa"));

        // 输入: s = "ab", t = "A"
        // 输出: ""
        System.out.println(new Solution76_2().minWindow("ab", "A"));

        // 输入: s = "abc", t = "cba"
        // 输出: ""
        System.out.println(new Solution76_2().minWindow("abc", "cba"));

        // 输入: s =
        // "aaaaaaaaaaaaaaaAabBcCdDeEfFgGhiHIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ"", t =
        // "aAabBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ"
        // 输出: "aAabBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ"
        System.out.println(
                new Solution76_1().minWindow("aaaaaaaaaaaaaaaAabBcCdDeEfFgGhiHIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ",
                        "aAabBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ"));
    }
}

/**
 * 最坏条件下的复杂度为O(mn)【遍历了太多毫无可能的情况】
 */
class Solution76_1 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        String result = "";
        int[] tcounts = new int[26 * 2];
        for (int i = 0; i < t.length(); i++) {
            tcounts[getIndex(t.charAt(i))]++;
        }
        for (int len = t.length(); len <= s.length(); len++) {
            int[] scounts = new int[26 * 2];
            for (int i = 0; i < len; i++) {
                scounts[getIndex(s.charAt(i))]++;
            }
            if (contains(scounts, tcounts)) {
                result = s.substring(0, len);
                return result;
            }

            for (int i = len; i < s.length(); i++) {
                scounts[getIndex(s.charAt(i - len))]--;
                scounts[getIndex(s.charAt(i))]++;
                if (contains(scounts, tcounts)) {
                    result = s.substring(i - len + 1, i + 1);
                    return result;
                }
            }

        }
        return result;
    }

    private int getIndex(char c) {
        return c < 'a' ? c - 'A' : c - 'a' + 26;
    }

    private boolean contains(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < arr2[i]) {
                return false;
            }
        }
        return true;
    }
}

/**
 * 双指针法，满足条件动右指针，不满足动左指针
 */
class Solution76_2 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] tcounts = new int[26 * 2];
        for (int i = 0; i < t.length(); i++) {
            tcounts[getIndex(t.charAt(i))]++;
        }

        int[] scounts = new int[26 * 2];
        for (int i = 0; i < t.length(); i++) {
            scounts[getIndex(s.charAt(i))]++;
        }
        if (contains(scounts, tcounts)) {
            return s.substring(0, t.length());
        }
        int l = 0;
        int r = t.length() - 1;
        String result = "";
        boolean found = false;
        while (true) {
            if (found) {
                l++;
                scounts[getIndex(s.charAt(l - 1))]--;
            } else {
                r++;
                if (r == s.length()) {
                    break;
                }
                scounts[getIndex(s.charAt(r))]++;
            }
            if (contains(scounts, tcounts)) {
                found = true;
                result = result == "" || r - l + 1 < result.length() ? s.substring(l, r + 1) : result;
            } else {
                found = false;
            }
        }
        return result;
    }

    private int getIndex(char c) {
        return c < 'a' ? c - 'A' : c - 'a' + 26;
    }

    private boolean contains(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < arr2[i]) {
                return false;
            }
        }

        return true;
    }
}