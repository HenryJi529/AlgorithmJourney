public class LeetCode11 {
    public static void main(String[] args) {
        // 输入：[1,8,6,2,5,4,8,3,7]
        // 输出：49
        System.out.println(new Solution11().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

        // 输入：height = [1,1]
        // 输出：1
        System.out.println(new Solution11().maxArea(new int[] { 1, 1 }));

    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int current = (j - i) * Math.min(height[i], height[j]);
            if (current > max) {
                max = current;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
