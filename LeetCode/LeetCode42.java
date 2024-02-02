public class LeetCode42 {
    public static void main(String[] args) {
        int[] height;
        // 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        // 输出：6
        height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(new Solution42().trap(height));

        // 输入：height = [4,2,0,3,2,5]
        // 输出：9
        height = new int[] { 4, 2, 0, 3, 2, 5 };
        System.out.println(new Solution42().trap(height));
    }
}

class Solution42 {
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