import java.util.Arrays;
import java.util.Comparator;

public class LeetCode435 {
    public static void main(String[] args) {
        // 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
        // 输出: 1
        System.out.println(
                new Solution435().eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));

        // 输入: intervals = [ [1,2], [1,2], [1,2] ]
        // 输出: 2
        System.out.println(
                new Solution435().eraseOverlapIntervals(new int[][] { { 1, 2 }, { 1, 2 }, {
                        1, 2 } }));

        // 输入: intervals = [ [1,2], [2,3] ]
        // 输出: 0
        System.out.println(
                new Solution435().eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }
                }));

        // 输入: intervals = [[1,100],[11,22],[1,11],[2,12]]
        // 输出: 2
        System.out.println(
                new Solution435()
                        .eraseOverlapIntervals(new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2,
                                12 } }));

        // 输入: intervals =
        // [[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
        // 输出: 7
        System.out.println(
                new Solution435().eraseOverlapIntervals(
                        new int[][] { { -52, 31 }, { -73, -26 }, { 82, 97 }, { -65, -11 }, { -62, -49
                        }, { 95, 99 },
                                { 58, 95 }, { -31, 49 }, { 66, 98 }, { -63, 2 }, { 30, 47 }, { -40, -26 }
                        }));
    }
}

class Solution435 {
    // NOTE: 贪心算法更新右边界
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
