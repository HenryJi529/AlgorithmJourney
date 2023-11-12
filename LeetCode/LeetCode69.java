// https://leetcode.cn/problems/sqrtx/description/

public class LeetCode69 {

    public static void main(String[] args) {
        int x = 2147395600;
        // int x = 2147483647;
        // int x = 10;
        System.out.println((new Solution4()).mySqrt(x));
    }
}

class Solution1 {
    public int mySqrt(int x) {
        int result = 0;
        while (true) {
            if (result * result <= x && (result + 1) * (result + 1) >= x) {
                if ((result + 1) * (result + 1) == x) {
                    return result + 1;
                } else {
                    return result;
                }
            }
            result++;
        }
    }
}

class Solution2 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));

        if ((ans + 1) * (ans + 1) == x) {
            return ans + 1;
        }
        if (ans * ans > x) {
            return ans - 1;
        }
        return ans;
    }
}

class Solution3 {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long) m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}

class Solution4 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int temp = x;
        while ((long) temp * temp > x) {
            temp = (int) (temp / 2 + (0.5 * (x / temp)));
        }
        if ((long) temp * temp <= x && (long) (temp + 1) * (temp + 1) > x) {
            return temp;
        }
        if ((long) (temp - 1) * (temp - 1) <= x && (long) (temp) * (temp) > x) {
            return temp - 1;
        }
        if ((long) (temp + 1) * (temp + 1) <= x && (long) (temp + 2) * (temp + 2) > x) {
            return temp + 1;
        }
        return 0;
    }
}