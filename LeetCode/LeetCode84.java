import java.util.Deque;
import java.util.ArrayDeque;

public class LeetCode84 {
    public static void main(String[] args) {
        int[] heights;
        // 输入：heights = [2,1,5,6,2,3]
        // 输出：10
        heights = new int[] { 2, 1, 5, 6, 2, 3 };
        System.out.println(new Solution84_2().largestRectangleArea(heights));

        // 输入： heights = [2,4]
        // 输出： 4
        heights = new int[] { 2, 4 };
        System.out.println(new Solution84_2().largestRectangleArea(heights));
    }
}

class Solution84_1 {
    // 暴力求解，会超时
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int length;
        for (int i = 0; i < heights.length; i++) {
            length = 0;
            for (int j = i; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    length++;
                } else {
                    break;
                }
            }
            for (int j = i; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    length++;
                } else {
                    break;
                }
            }
            length--;
            // System.out.println(String.format("i: %d, heights[i]: %d, length: %d", i,
            // heights[i], length));
            max = Math.max(max, heights[i] * length);
        }
        return max;
    }
}

class Solution84_2 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
