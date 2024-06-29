import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode22 {
    public static void main(String[] args) {
        // 输入：n = 3
        // 输出：["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(Arrays.toString(new Solution22_4().generateParenthesis(3).toArray()));

        // 输入：n = 1
        // 输出：["()"]
        System.out.println(Arrays.toString(new Solution22_4().generateParenthesis(1).toArray()));

        // 输入：n = 4
        System.out.println(Arrays.toString(new Solution22_4().generateParenthesis(4).toArray()));
    }
}

/**
 * 该解法的思路是ab/(a)/a()/()a
 */
class Solution22_1 {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        List<HashSet<String>> dp = new LinkedList<HashSet<String>>();
        dp.add(new HashSet<>(List.of("()")));
        for (int i = 2; i <= n; i++) {
            HashSet<String> set = new HashSet<>();
            for (String s : dp.get(i - 2)) {
                set.add("()" + s);
                set.add(s + "()");
                set.add("(" + s + ")");
            }
            for (int j = i - 2; j >= i / 2; j--) {
                for (String s1 : dp.get(j - 1)) {
                    for (String s2 : dp.get(i - j - 1)) {
                        set.add(s1 + s2);
                        set.add(s2 + s1);
                    }
                }
            }
            dp.add(set);
        }
        return new LinkedList<String>(dp.getLast());
    }
}

/**
 * 该表达式的思路是(a)b
 */
class Solution22_2 {
    @SuppressWarnings("unchecked")
    ArrayList<String>[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generate(c)) {
                    for (String right : generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }
}

/**
 * 该方法的思路是a[0:i] () a[i:-1]
 */
class Solution22_3 {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        HashSet<String> set = new HashSet<>();
        for (String str : generateParenthesis(n - 1)) {
            for (int i = 0; i <= str.length() / 2; i++) {
                set.add(str.substring(0, i) + "()" + str.substring(i, str.length()));
            }
        }
        return new ArrayList<>(set);
    }
}

/**
 * 该方法的思路也是a[0:i] () a[i:-1]，但采用了递推
 */

class Solution22_4 {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }

        HashSet<String> set = new HashSet<>(List.of("()"));
        List<String> result = null;
        for (int i = 2; i <= n; i++) {
            result = new ArrayList<>();
            for (String str : set) {
                for (int j = 0; j <= str.length() / 2; j++) {
                    result.add(str.substring(0, j) + "()" + str.substring(j, str.length()));
                }
            }
            set = new HashSet<>(result);
        }
        return new ArrayList<>(set);
    }
}