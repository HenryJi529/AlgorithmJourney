import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode735 {
    public static void main(String[] args) {
        int[] asteroids;
        // 输入：asteroids = [5,10,-5]
        // 输出：[5,10]
        asteroids = new int[] { 5, 10, -5 };
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(asteroids)));

        // 输入：asteroids = [8,-8]
        // 输出：[]
        asteroids = new int[] { 8, -8 };
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(asteroids)));

        // 输入：asteroids = [10,2,-5]
        // 输出：[10]
        asteroids = new int[] { 10, 2, -5 };
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(asteroids)));

        // 输入：asteroids = [-2,-1,1,2]
        // 输出：[-2, -1, 1, 2]
        asteroids = new int[] { -2, -1, 1, 2 };
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(asteroids)));

        // 输入：asteroids = [1,-2,-2,-2]
        // 输出：[-2,-2,-2]
        asteroids = new int[] { 1, -2, -2, -2 };
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(asteroids)));
    }
}

class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            // System.out.println("考虑"+ curr);
            while (!stack.isEmpty()) {
                int pre = stack.peek();
                if (!(pre > 0 && curr < 0)) {
                    // 只有相向才撞
                    stack.push(curr);
                    // System.out.println("同向不碰撞，放入" + curr);
                    break;
                } else {
                    int comp = Math.abs(curr) - Math.abs(pre);
                    if (comp > 0) {
                        // curr大则pre被撞碎，还能接着撞
                        stack.pop();
                        // System.out.println(String.format("%d撞碎%d", curr, pre));
                    } else if (comp < 0) {
                        // curr小则curr被撞碎
                        // System.out.println(String.format("%d撞碎%d", pre, curr));
                        break;
                    } else {
                        // 两个都被撞碎
                        stack.pop();
                        curr = Integer.MIN_VALUE;
                        // System.out.println(String.format("%d和%d都碎", curr, pre));
                        break;
                    }
                }
            }
            if (stack.isEmpty() && curr != Integer.MIN_VALUE) {
                stack.push(curr);
                // System.out.println("放入" + curr);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}