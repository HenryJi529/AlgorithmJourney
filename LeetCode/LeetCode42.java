public class LeetCode42 {
    public static void main(String[] args) {
        int[] height;
        // 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        // 输出：6
        height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(new Solution42_2().trap(height));

        // 输入：height = [4,2,0,3,2,5]
        // 输出：9
        height = new int[] { 4, 2, 0, 3, 2, 5 };
        System.out.println(new Solution42_2().trap(height));
    }
}

/**
 * 寻找可以盛水的区间
 */
class Solution42_1 {
    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int start = 0;
        int end = 1;
        int sum = 0;
        while (start < height.length - 1) {
            if (height[end] >= height[start]) {
                for (int i = start + 1; i < end; i++) {
                    sum += height[start] - height[i];
                }
                start = end;
            } else {
                // 如果搜索到最后，还没找到更高的右边界，就利用这个最高点，搜索比它矮一点的右边界
                if (end == height.length - 1) {
                    height[start] -= 1;
                    end = start;
                }
            }
            end++;
        }
        return sum;
    }
}

/**
 * DP查找节点两边的最大值
 */
class Solution42_2 {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
