public class LeetCode509 {
    public static void main(String[] args) {
        // 输入：n = 2
        // 输出：1
        System.out.println(new Solution509().fib(2));

        // 输入：n = 3
        // 输出：2
        System.out.println(new Solution509().fib(3));

        // 输入：n = 4
        // 输出：3
        System.out.println(new Solution509().fib(4));

        // 输入：n = 5
        // 输出：5
        System.out.println(new Solution509().fib(5));
    }
}

class Solution509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}