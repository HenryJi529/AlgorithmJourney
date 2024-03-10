import java.util.Arrays;

public class LeetCode1637 {
    public static void main(String[] args) {
        // 输入：points = [[8,7],[9,9],[7,4],[9,7]]
        // 输出：1
        System.out.println(
                new Solution1637().maxWidthOfVerticalArea(new int[][] { { 8, 7 }, { 9, 9 }, { 7, 4 }, { 9, 7 } }));

        // 输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
        // 输出：3
        System.out.println(
                new Solution1637().maxWidthOfVerticalArea(
                        new int[][] { { 3, 1 }, { 9, 0 }, { 1, 0 }, { 1, 4 }, { 5, 3 }, { 8, 8 } }));

        // 输入：points = [[2,4],[10,10],[6,8],[6,8],[6,10],[8,6],[5,3]]
        // 输出：3
        System.out.println(
                new Solution1637().maxWidthOfVerticalArea(
                        new int[][] { { 2, 4 }, { 10, 10 }, { 6, 8 }, { 6, 8 }, { 6, 10 }, { 8, 6 }, { 5, 3 } }));
    }
}

class Solution1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[0] - b[0]));
        // System.out.println(Arrays.deepToString(points));
        int ans = points[1][0] - points[0][0];
        for (int i = 2; i < points.length; i++) {
            ans = Math.max(points[i][0] - points[i - 1][0], ans);
        }
        return ans;
    }
}
