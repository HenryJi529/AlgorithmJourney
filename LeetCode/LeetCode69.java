public class LeetCode69 {

    public static void main(String[] args) {
        // 输入：x = 4
        // 输出：2
        System.out.println(new Solution69_1().mySqrt(4));

        // 输入：x = 8
        // 输出：2
        System.out.println(new Solution69_1().mySqrt(8));
    }
}

class Solution69_1 {
    public int mySqrt(int x) {
        int l = 0, r = x;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((long) mid * mid < x) {
                l = mid + 1;
            } else if ((long) mid * mid > x) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return l - 1;
    }
}

class Solution69_2 {
    // 「袖珍计算器算法」是一种用指数函数exp⁡和对数函数ln代替平方根函数的方法。我们通过有限的可以使用的数学函数，得到我们想要计算的结果。
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x)); // 浮点数计算会带来误差，需要进一步处理

        if ((ans + 1) * (ans + 1) == x) {
            return ans + 1;
        }
        if (ans * ans > x) {
            return ans - 1;
        }
        return ans;
    }
}

class Solution69_3 {
    // 牛顿迭代法
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}