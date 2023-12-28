import java.util.HashMap;

public class LeetCode91 {
    public static void main(String[] args) {
        // 输入：s = "12"
        // 输出：2
        System.out.println(new Solution91_2().numDecodings("12"));

        // 输入：s = "226"
        // 输出：3
        System.out.println(new Solution91_2().numDecodings("226"));

        // 输入：s = "06"
        // 输出：0
        System.out.println(new Solution91_2().numDecodings("06"));

        // 输入：s = "06"
        // 输出：0
        System.out.println(new Solution91_2().numDecodings("26"));
    }
}

class Solution91_1 {
    // NOTE: 虽然结果是对的，但思路有些混乱
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int numDecodings(String s) {
        if (s.length() == 1) {
            return getFromOneNum(0, s);
        } else if (s.length() == 2) {
            return getFromTwoNum(0, 1, s);
        } else {
            memo.put(1, getFromOneNum(0, s));
            memo.put(2, getFromTwoNum(0, 1, s));
            return dp(s.length(), s);
        }

    }

    public int dp(int n, String s) {
        // [0, n]内的数量
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int ans = dp(n - 2, s) * (getFromTwoNum(n - 2, n - 1, s) - (getFromOneNum(n - 2, s) * getFromOneNum(n - 1, s)))
                + dp(n - 1, s) * getFromOneNum(n - 1, s);
        memo.put(n, ans);
        return ans;
    }

    public int getFromTwoNum(int start, int end, String s) {
        if (s.charAt(start) != '0' && s.charAt(end) != '0') {
            return ((int) (s.charAt(start) - '0') * 10 + (int) (s.charAt(end) - '0') <= 26 ? 1 : 0) + 1;
        } else if (s.charAt(start) != '0' || s.charAt(end) != '0') {
            if (s.charAt(start) == '0') {
                return 0;
            } else {
                if ((s.charAt(start) - '0') <= 2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
    }

    public int getFromOneNum(int start, String s) {
        if (s.charAt(start) != '0') {
            return 1;
        } else {
            return 0;
        }
    }
}

class Solution91_2 {
    // NOTE: 思路更清晰的版本，且空间复杂度更低
    int[] memo;

    public int numDecodings(String s) {
        if (s.length() == 1) {
            return getFromOneNum(0, s);
        } else if (s.length() == 2) {
            return getFromTwoNum(0, 1, s) + getFromOneNum(0, s) * getFromOneNum(1,
                    s);
        } else {
            memo = new int[s.length() + 1];
            for (int i = 1; i < s.length() + 1; i++) {
                memo[i] = -1;
            }
            memo[1] = getFromOneNum(0, s);
            memo[2] = getFromTwoNum(0, 1, s) + getFromOneNum(0, s) * getFromOneNum(1,
                    s);
            return dp(s.length(), s);
        }

    }

    public int dp(int n, String s) {
        // [0, n]内的数量
        if (memo[n] != -1) {
            return memo[n];
        }
        int ans = dp(n - 2, s) * getFromTwoNum(n - 2, n - 1, s)
                + dp(n - 1, s) * getFromOneNum(n - 1, s);
        memo[n] = ans;
        return ans;
    }

    public int getFromTwoNum(int start, int end, String s) {
        if (s.charAt(start) != '0' && s.charAt(end) != '0') {
            return ((int) (s.charAt(start) - '0') * 10 + (int) (s.charAt(end) - '0') <= 26 ? 1 : 0);
        } else if (s.charAt(start) != '0') {
            if ((s.charAt(start) - '0') <= 2) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public int getFromOneNum(int start, String s) {
        if (s.charAt(start) != '0') {
            return 1;
        } else {
            return 0;
        }
    }
}
