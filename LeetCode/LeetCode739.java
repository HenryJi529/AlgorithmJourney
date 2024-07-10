import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode739 {
    public static void main(String[] args) {
        // 输入: temperatures = [73,74,75,71,69,72,76,73]
        // 输出: [1,1,4,2,1,1,0,0]
        System.out.println(
                Arrays.toString(new Solution739_2().dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));

        // 输入: temperatures = [30,40,50,60]
        // 输出: [1,1,1,0]
        System.out.println(
                Arrays.toString(new Solution739_2().dailyTemperatures(new int[] { 30, 40, 50, 60 })));

        // 输入: temperatures = [30,60,90]
        // 输出: [1,1,0]
        System.out.println(
                Arrays.toString(new Solution739_2().dailyTemperatures(new int[] { 30, 60, 90 })));

        // 输入: temperatures = [99,99,99,100]
        // 输出: [3,2,1,0]
        System.out.println(
                Arrays.toString(new Solution739_2().dailyTemperatures(new int[] { 99, 99, 99, 100 })));

        // 输入: temperatures = [34,80,80,34,34,80,80,80,80,34]
        // 输出: [1,0,0,2,1,0,0,0,0,0]
        System.out.println(
                Arrays.toString(
                        new Solution739_2().dailyTemperatures(new int[] { 34, 80, 80, 34, 34, 80, 80, 80, 80, 34 })));
    }
}

class Solution739_1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if (res.length == 1) {
            return res;
        }

        for (int i = 0; i < res.length; i++) {
            if (i < res.length - 1 && temperatures[i] == temperatures[i + 1]) {
                // NOTE: 有助于解决相等元素多的情况
                res[i] = -1;
                continue;
            }
            for (int j = i + 1; j < res.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] == -1) {
                if (res[i + 1] != 0) {
                    res[i] = res[i + 1] + 1;
                } else {
                    res[i] = 0;
                }
            }
        }

        return res;
    }
}

/**
 * 递减栈
 */
class Solution739_2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (temperatures[stack.peek()] > temperatures[i]) {
                    res[i] = stack.peek() - i;
                    stack.push(i);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                res[i] = 0;
                stack.push(i);
            }
        }
        return res;
    }
}