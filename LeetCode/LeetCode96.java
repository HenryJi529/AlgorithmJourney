import java.util.HashMap;

public class LeetCode96 {
    public static void main(String[] args) {
        // 输入：n = 3
        // 输出：5
        System.out.println(new Solution96().numTrees(3));

        // 输入：n = 1
        // 输出：1
        System.out.println(new Solution96().numTrees(1));
    }
}

class Solution96 {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // NOTE: 这个问题用数组来存储更有效率
    public int numTrees(int n) {
        map.put(1, 1);
        map.put(2, 2);
        return dp(n, map);
    }

    public int dp(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = 0;
        // 首和尾都是0,n-1的格式；中间是i,n-i-1的格式
        sum += 2 * dp(n - 1, map);
        for (int i = 1; i <= n - 2; i++) {
            sum += dp(i, map) * dp(n - 1 - i, map);
        }
        return sum;
    }
}
