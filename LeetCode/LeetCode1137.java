public class LeetCode1137 {
    public static void main(String[] args) {
        // 输入：n = 4
        // 输出：4
        System.out.println(new Solution1137().tribonacci(4));

        // 输入：n = 25
        // 输出：1389537
        System.out.println(new Solution1137().tribonacci(25));

    }
}

class Solution1137 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        while (n > 2) {
            int temp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
            n--;
        }
        return t2;
    }
}