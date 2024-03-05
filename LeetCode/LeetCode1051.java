import java.util.Arrays;

public class LeetCode1051 {
    public static void main(String[] args) {
        // 输入：heights = [1,1,4,2,1,3]
        // 输出：3
        System.out.println(new Solution1051().heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));

        // 输入：heights = [5,1,2,3,4]
        // 输出：5
        System.out.println(new Solution1051().heightChecker(new int[] { 5, 1, 2, 3, 4 }));

        // 输入：heights = [1,2,3,4,5]
        // 输出：0
        System.out.println(new Solution1051().heightChecker(new int[] { 1, 2, 3, 4, 5 }));

    }
}

class Solution1051 {
    public int heightChecker(int[] heights) {
        int[] order = Arrays.copyOf(heights, heights.length);
        Arrays.sort(order);
        int ans = 0;
        for (int i = 0; i < order.length; i++) {
            if (order[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }
}