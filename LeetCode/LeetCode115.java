import java.util.HashMap;
import java.util.ArrayList;

public class LeetCode115 {
    public static void main(String[] args) {
        // 输入：s = "rabbbit", t = "rabbit"
        // 输出：3
        System.out.println(new Solution115_2().numDistinct("rabbbit", "rabbit"));

        // 输入：s = "babgbag", t = "bag"
        // 输出：5
        System.out.println(new Solution115_2().numDistinct("babgbag", "bag"));

        // 输入：s =
        // "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
        // t = "bcddceeeebecbc"
        // 输出：
        System.out.println(new Solution115_2().numDistinct(
                "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
                "bcddceeeebecbc"));
    }
}

class Solution115_1 {
    // NOTE: 复杂度太高
    int count = 0;

    public int numDistinct(String s, String t) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(s.charAt(i), list);
            }
        }
        // System.out.println(map);
        search(s, t, map, 0, 0);
        return count;
    }

    private void search(String s, String t, HashMap<Character, ArrayList<Integer>> map, int sPointer, int tPointer) {
        // System.out.println(String.format("%d %d", sPointer, tPointer));
        if (tPointer == t.length()) {
            count++;
            return;
        }

        if (sPointer == s.length()) {
            return;
        }
        char c = t.charAt(tPointer);
        if (!map.containsKey(c)) {
            return;
        }
        ArrayList<Integer> sLocs = map.get(c);
        int sInd = find_start_location(sLocs, sPointer);
        for (int i = sInd; i < sLocs.size(); i++) {
            search(s, t, map, sLocs.get(i) + 1, tPointer + 1);
        }
    }

    private int find_start_location(ArrayList<Integer> locs, int loc) {
        int l = 0;
        int r = locs.size() - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (locs.get(mid) < loc) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

class Solution115_2 {
    int[][] dp;

    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        // 初始化
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                dp[i][0] = s.charAt(i) == t.charAt(0) ? 1 : 0;
            } else {
                dp[i][0] = s.charAt(i) == t.charAt(0) ? dp[i - 1][0] + 1 : dp[i - 1][0];
            }
        }
        // 迭代赋值
        for (int j = 1; j < t.length(); j++) {
            for (int i = j; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length() - 1][t.length() - 1];
    }
}