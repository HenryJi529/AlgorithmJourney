public class LeetCode121 {
    public static void main(String[] args) {
        // 输入：[7,1,5,3,6,4]
        // 输出：5
        System.out.println(new Solution121().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));

        // 输入：prices = [7,6,4,3,1]
        // 输出：0
        System.out.println(new Solution121().maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }
}

class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int result = 0;
        int currentMax = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            result = Math.max(result, currentMax - prices[i]);
            currentMax = Math.max(currentMax, prices[i]);
        }
        return result;
    }
}