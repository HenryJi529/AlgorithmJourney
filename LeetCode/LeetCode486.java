public class LeetCode486 {
    public static void main(String[] args) {
        // 输入：nums = [1,5,2]
        // 输出：false
        System.out.println(new Solution486().predictTheWinner(new int[] { 1, 5, 2 }));

        // 输入：nums = [1,5,233,7]
        // 输出：true
        System.out.println(new Solution486().predictTheWinner(new int[] { 1, 5, 233, 7 }));
    }
}

class Solution486 {
    Integer[][] dp;

    public boolean predictTheWinner(int[] piles) {
        dp = new Integer[piles.length][piles.length];
        return score(piles, 0, piles.length - 1) >= 0;
    }

    public int score(int[] piles, int l, int r) {
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        int result;
        if (l == r) {
            result = piles[l];
        } else {
            result = Math.max(piles[l] - score(piles, l + 1, r), piles[r] - score(piles, l, r - 1));
        }
        dp[l][r] = result;
        return result;
    }
}