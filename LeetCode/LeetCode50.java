import java.util.HashMap;

public class LeetCode50 {
    public static void main(String[] args) {
        // 输入：x = 2.00000, n = 10
        // 输出：1024.00000
        System.out.println(new Solution50_2().myPow(2.0000, 10));

        // 输入：x = 2.10000, n = 3
        // 输出：9.26100
        System.out.println(new Solution50_2().myPow(2.10000, 3));

        // 输入：x = 2.00000, n = -2
        // 输出：0.25000
        // 解释：2-2 = 1/22 = 1/4 = 0.25
        System.out.println(new Solution50_2().myPow(2.0000, -2));

        // 输入：x = 2.00000, n = -2147483648
        // 输出：
        System.out.println(new Solution50_3().myPow(2.00000, -2147483648));
    }
}

class Solution50_1 {
    // NOTE: 完全没有必要存储这么多中间结果
    HashMap<Integer, Double> map = new HashMap<Integer, Double>();

    public double myPow(double x, int n) {
        map.put(0, 1.0);
        map.put(1, x);
        map.put(2, x * x);
        if (n < 0) {
            return 1.0 / myPower(x, -n);
        } else {
            return myPower(x, n);
        }
    }

    public double myPower(double x, int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        double result;
        double half = myPower(x, n / 2);
        if (n % 2 == 0) {
            result = half * half;
        } else {
            result = half * half * x;
        }
        map.put(n, result);
        return result;
    }
}

class Solution50_2 {
    public double myPow(double x, int n) {
        // NOTE: 这里存在溢出风险
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        if (n == 0) {
            return 1.0;
        }
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
}

class Solution50_3 {
    public double myPow(double x, int n) {
        long l = n;
        if (n < 0) {
            return 1.0 / quickPow(x, -l);
        } else {
            return quickPow(x, l);
        }
    }

    public double quickPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double temp = quickPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
}
