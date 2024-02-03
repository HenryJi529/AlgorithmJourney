public class LeetCode9 {
    public static void main(String[] args) {
        // 输入：x = 121
        // 输出：true
        System.out.println(new Solution9().isPalindrome(121));

        // 输入：x = -121
        // 输出：false
        System.out.println(new Solution9().isPalindrome(-121));

        // 输入：x = 10
        // 输出：false
        System.out.println(new Solution9().isPalindrome(10));
    }
}

class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);

        return isPalindrome2(s, 0, s.length() - 1);
    }

    public boolean isPalindrome1(String s, int start, int end) {
        int length = end - start;
        if (length <= 0) {
            return true;
        } else {
            if (s.charAt(start) == s.charAt(end)) {
                return isPalindrome1(s, start + 1, end - 1);
            } else {
                return false;
            }
        }
    }

    public boolean isPalindrome2(String s, int start, int end) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
