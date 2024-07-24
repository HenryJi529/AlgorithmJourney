import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode739 {
    public static void main(String[] args) {
        // 输入: temperatures = [73,74,75,71,69,72,76,73]
        // 输出: [1,1,4,2,1,1,0,0]
        System.out.println(
                Arrays.toString(new Solution739().dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));

        // 输入: temperatures = [30,40,50,60]
        // 输出: [1,1,1,0]
        System.out.println(
                Arrays.toString(new Solution739().dailyTemperatures(new int[] { 30, 40, 50, 60 })));

        // 输入: temperatures = [30,60,90]
        // 输出: [1,1,0]
        System.out.println(
                Arrays.toString(new Solution739().dailyTemperatures(new int[] { 30, 60, 90 })));

        // 输入: temperatures = [99,99,99,100]
        // 输出: [3,2,1,0]
        System.out.println(
                Arrays.toString(new Solution739().dailyTemperatures(new int[] { 99, 99, 99, 100 })));

        // 输入: temperatures = [34,80,80,34,34,80,80,80,80,34]
        // 输出: [1,0,0,2,1,0,0,0,0,0]
        System.out.println(
                Arrays.toString(
                        new Solution739().dailyTemperatures(new int[] { 34, 80, 80, 34, 34, 80, 80, 80, 80, 34 })));
    }
}

/**
 * 递减栈
 */
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int top = stack.pop();
                res[top] = i - top;
            }
            stack.push(i);
        }
        return res;
    }
}