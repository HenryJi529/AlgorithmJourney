public class LeetCode1422 {
    public static void main(String[] args) {
        // 输入：s = "011101"
        // 输出：5
        System.out.println(new Solution1422().maxScore("011101"));

        // 输入：s = "00111"
        // 输出：5
        System.out.println(new Solution1422().maxScore("00111"));

        // 输入：s = "1111"
        // 输出：3
        System.out.println(new Solution1422().maxScore("1111"));
    }
}

class Solution1422 {
    public int maxScore(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                right--;
            } else {
                left++;
            }
            ans = Math.max(ans, left + right);
        }
        return ans;
    }
}