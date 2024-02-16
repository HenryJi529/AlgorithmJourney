import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class LeetCode56 {
    public static void main(String[] args) {
        // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        // 输出：[[1,6],[8,10],[15,18]]
        System.out.println(
                Arrays.deepToString(new Solution56().merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));

        // 输入：intervals = [[1,4],[4,5]]
        // 输出：[[1,5]]
        System.out.println(Arrays.deepToString(new Solution56().merge(new int[][] { { 1, 4 }, { 4, 5 }
        })));

        // 输入：intervals = [[1,4],[2,3]]
        // 输出：[[1,4]]
        System.out.println(Arrays.deepToString(new Solution56().merge(new int[][] { { 1, 4 }, { 2, 3 }
        })));
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        ArrayList<int[]> merged = new ArrayList<int[]>();
        int slow = 0;
        int fast = 1;
        int currentEnd = intervals[0][0];
        while (fast < intervals.length) {
            currentEnd = Math.max(currentEnd, intervals[fast - 1][1]);
            if (currentEnd < intervals[fast][0]) {
                // 无法覆盖
                merged.add(new int[] { intervals[slow][0], currentEnd });
                slow = fast;
            }
            fast++;
        }
        if (slow != fast) {
            merged.add(new int[] { intervals[slow][0], Math.max(intervals[fast - 1][1], currentEnd) });
        }
        // System.out.println(Arrays.deepToString(merged.toArray()));
        return merged.toArray(new int[merged.size()][]);
    }
}