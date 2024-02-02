public class LeetCode877 {
    public static void main(String[] args) {
        // 输入：piles = [5,3,4,5]
        // 输出：true
        System.out.println(new Solution877_2().stoneGame(new int[] { 5, 3, 4, 5 }));

        // 输入：piles = [3,7,2,3]
        // 输出：true
        System.out.println(new Solution877_2().stoneGame(new int[] { 3, 7, 2, 3 }));
    }
}

class Solution877_1 {
    // NOTE: 脑筋急转弯
    public boolean stoneGame(int[] piles) {
        return true;
    }
}

class Solution877_2 {
    Integer[][] dp;

    public boolean stoneGame(int[] piles) {
        dp = new Integer[piles.length][piles.length];
        return score(piles, 0, piles.length - 1) > 0;
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