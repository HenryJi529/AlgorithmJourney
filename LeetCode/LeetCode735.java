import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class LeetCode735 {
    public static void main(String[] args) {
        int[] asteroids;
        // 输入：asteroids = [5,10,-5]
        // 输出：[5,10]
        asteroids = new int[] { 5, 10, -5 };
        System.out.println(Arrays.toString(new Solution735_2().asteroidCollision(asteroids)));

        // 输入：asteroids = [8,-8]
        // 输出：[]
        asteroids = new int[] { 8, -8 };
        System.out.println(Arrays.toString(new Solution735_2().asteroidCollision(asteroids)));

        // 输入：asteroids = [10,2,-5]
        // 输出：[10]
        asteroids = new int[] { 10, 2, -5 };
        System.out.println(Arrays.toString(new Solution735_2().asteroidCollision(asteroids)));

        // 输入：asteroids = [-2,-1,1,2]
        // 输出：[]
        asteroids = new int[] { -2, -1, 1, 2 };
        System.out.println(Arrays.toString(new Solution735_2().asteroidCollision(asteroids)));

        // 输入：asteroids = [1,-2,-2,-2]
        // 输出：[]
        asteroids = new int[] { 1, -2, -2, -2 };
        System.out.println(Arrays.toString(new Solution735_2().asteroidCollision(asteroids)));
    }
}

class Solution735_1 {
    // NOTE: 错在没有考虑清楚反向的问题
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                while (true) {
                    int top = stack.peek();
                    if (Math.abs(top + asteroids[i]) != Math.abs(top) + Math.abs(asteroids[i])) {
                        if (Math.abs(top) < Math.abs(asteroids[i])) {
                            stack.pop();
                        } else if (Math.abs(top) == Math.abs(asteroids[i])) {
                            stack.pop();
                            break;
                        } else {
                            break;
                        }
                    } else {
                        stack.push(asteroids[i]);
                        break;
                    }
                }
            }
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}

class Solution735_2 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                int top = stack.peek();
                while (true) {
                    if (top > 0 && asteroids[i] < 0) {
                        if (top < -asteroids[i]) {
                            stack.pop();
                            if (stack.isEmpty()) {
                                stack.push(asteroids[i]);
                                break;
                            } else {
                                top = stack.peek();
                            }
                        } else if (top == -asteroids[i]) {
                            stack.pop();
                            break;
                        } else {
                            break;
                        }
                    } else {
                        stack.push(asteroids[i]);
                        break;
                    }
                }
            }
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}