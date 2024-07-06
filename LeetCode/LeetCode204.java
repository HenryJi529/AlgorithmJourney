import java.util.Arrays;

public class LeetCode204 {
    public static void main(String[] args) {
        // 输入：n = 10
        // 输出：4
        System.out.println(new Solution204_2().countPrimes(10));

        // 输入：n = 0
        // 输出：0
        System.out.println(new Solution204_2().countPrimes(0));

        // 输入：n = 1
        // 输出：0
        System.out.println(new Solution204_2().countPrimes(1));

        // 输入：n = 3
        // 输出：1
        System.out.println(new Solution204_2().countPrimes(3));
    }
}

/**
 * 暴力求解，每个isPrime还需要O(n^(1/2)/3)的复杂度
 */
class Solution204_1 {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                sum++;
            }
        }
        return sum;
    }

    private boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/**
 * 埃拉托斯特尼筛法
 */
class Solution204_2 {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        isPrimes[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                for (int j = 2; i * j < n; j++) {
                    isPrimes[j * i] = false;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (isPrimes[i]) {
                sum++;
            }
        }
        return sum;
    }

}