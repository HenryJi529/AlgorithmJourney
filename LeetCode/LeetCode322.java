import java.util.Arrays;

public class LeetCode322 {
    public static void main(String[] args) {
        // 输入：coins = [1, 2, 5], amount = 11
        // 输出：3
        System.out.println(new Solution322_3().coinChange(new int[] { 1, 2, 5 },
                11));

        // 输入：coins = [2], amount = 3
        // 输出：-1
        System.out.println(new Solution322_3().coinChange(new int[] { 2 }, 3));

        // 输入：coins = [1], amount = 0
        // 输出：0
        System.out.println(new Solution322_3().coinChange(new int[] { 1 }, 0));

        // 输入：coins = [186,419,83,408], amount = 6249
        // 输出：20
        System.out.println(new Solution322_3().coinChange(new int[] { 186, 419, 83,
                408 }, 6249));
    }
}

/**
 * NOTE: 贪心不能解决问题，因为存在两中替代一大+两小的情况
 */
class Solution322_1 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));

        return change(coins, coins.length - 1, amount);
    }

    public int change(int[] coins, int currentCoinIndex, int amount) {
        if (amount == 0) {
            return 0;
        }
        for (int i = amount / coins[currentCoinIndex]; i >= 0; i--) {
            int remainAmount = amount - coins[currentCoinIndex] * i;
            if (remainAmount == 0) {
                return i;
            }
            if (remainAmount < 0) {
                continue;
            }
            if (currentCoinIndex - 1 < 0) {
                return -1;
            }
            int left = change(coins, currentCoinIndex - 1, remainAmount);
            if (left == -1) {
                continue;
            } else {
                return left + i;
            }
        }
        return -1;
    }
}

/**
 * 正确的关系是F(S) = min{F(S-coins[1]), F(S-coins[2])...} + 1
 */
class Solution322_2 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0) {
            return 0;
        }
        return search(coins, amount, new Integer[amount + 1]);
    }

    public int search(int[] coins, int amount, Integer[] dp) {
        int result = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int remainAmount = amount - coins[i];
            if (remainAmount < 0) {
                continue;
            }
            if (remainAmount == 0) {
                result = 1;
                dp[amount] = 1;
                return 1;
            }
            if (dp[remainAmount] != null) {
                if (dp[remainAmount] != -1) {
                    result = Math.min(result, dp[remainAmount] + 1);
                }
            } else {
                int temp = search(coins, remainAmount, dp);
                if (temp != -1) {
                    result = Math.min(result, temp + 1);
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        dp[amount] = result;
        return result;
    }
}

/**
 * 正向填表效率更高
 */
class Solution322_3 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // NOTE: 避免溢出
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
    }
}