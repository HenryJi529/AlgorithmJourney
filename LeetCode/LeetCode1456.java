public class LeetCode1456 {
    public static void main(String[] args) {
        // 输入：s = "abciiidef", k = 3
        // 输出：3
        System.out.println(new Solution1456_2().maxVowels("abciiidef", 3));

        // 输入：s = "aeiou", k = 2
        // 输出：2
        System.out.println(new Solution1456_2().maxVowels("aeiou", 2));

        // 输入：s = "leetcode", k = 3
        // 输出：2
        System.out.println(new Solution1456_2().maxVowels("leetcode", 3));

        // 输入：s = "rhythms", k = 4
        // 输出：0
        System.out.println(new Solution1456_2().maxVowels("rhythms", 4));

        // 输入：s = "tryhard", k = 4
        // 输出：1
        System.out.println(new Solution1456_2().maxVowels("tryhard", 4));
    }
}

/**
 * DP复杂度为O(nk)，会超时(102/106)
 */
class Solution1456_1 {
    public int maxVowels(String s, int k) {
        boolean[] vowels = new boolean[s.length()];
        int[] dp = new int[s.length()];
        int ans = 0;
        // 初始化
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels[i] = true;
                dp[i] = 1;
                ans = 1;
            }
        }
        for (int len = 2; len <= k; len++) {
            for (int i = dp.length - 1; i >= len - 1; i--) {
                dp[i] = dp[i - 1];
                if (vowels[i]) {
                    dp[i]++;
                    ans = Math.max(ans, dp[i]);
                    if (ans == k) {
                        return k;
                    }
                }

            }
        }
        return ans;
    }
}

class Solution1456_2 {
    public int maxVowels(String s, int k) {
        boolean[] vowels = new boolean[s.length()]; // NOTE: 也可以不提前判断，因为大部分元素只判断一次

        // 初始化
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels[i] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += vowels[i] ? 1 : 0;
        }
        int ans = count;
        for (int i = k; i < s.length(); i++) {
            count -= vowels[i - k] ? 1 : 0;
            count += vowels[i] ? 1 : 0;
            ans = Math.max(count, ans);
        }
        return ans;
    }
}