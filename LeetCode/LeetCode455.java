import java.util.Arrays;

public class LeetCode455 {
    public static void main(String[] args) {
        // 输入: g = [1,2,3], s = [1,1]
        // 输出: 1
        System.out.println(new Solution455().findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));

        // 输入: g = [1,2], s = [1,2,3]
        // 输出: 2
        System.out.println(new Solution455().findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));
    }
}

class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0;
        int p2 = 0;
        while (p1 < g.length && p2 < s.length) {
            if (g[p1] <= s[p2]) {
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return p1;
    }
}