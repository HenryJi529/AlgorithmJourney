import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode2054 {
    public static void main(String[] args) {
        // 输入：events = [[1,3,2],[4,5,2],[2,4,3]]
        // 输出：4
        System.out.println(new Solution2054_2().maxTwoEvents(new int[][] { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } }));

        // 输入：events = [[1,3,2],[4,5,2],[1,5,5]]
        // 输出：5
        System.out.println(new Solution2054_2().maxTwoEvents(new int[][] { { 1, 3, 2 }, { 4, 5, 2 }, { 1, 5, 5 } }));

        // 输入：events = [[1,5,3],[1,5,1],[6,6,5]]
        // 输出：8
        System.out.println(new Solution2054_2().maxTwoEvents(new int[][] { { 1, 5, 3 }, { 1, 5, 1 }, { 6, 6, 5 } }));

        // 输入：events = [[10,83,53],[63,87,45],[97,100,32],[51,61,16]]
        // 输出：85
        System.out.println(new Solution2054_2()
                .maxTwoEvents(new int[][] { { 10, 83, 53 }, { 63, 87, 45 }, { 97, 100, 32 }, { 51, 61, 16 } }));

    }
}

class Solution2054_1 {
    // 该解法会超时
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // System.out.println(Arrays.deepToString(events));
        int ans = 0;
        for (int i = 0; i < events.length; i++) {
            ans = Math.max(ans, events[i][2]);
        }
        for (int i = 0; i < events.length; i++) {
            for (int j = events.length - 1; j >= 0; j--) {
                if (events[i][1] >= events[j][0]) {
                    break;
                }
                ans = Math.max(ans, events[i][2] + events[j][2]);
            }
        }
        return ans;
    }
}

class Solution2054_2 {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        // System.out.println(Arrays.deepToString(events));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int ans = 0;
        int max = 0;
        for (int[] e : events) {
            while (queue.size() > 0 && queue.peek()[1] < e[0]) {
                max = Math.max(max, queue.poll()[2]);
            }
            ans = Math.max(ans, max + e[2]);
            queue.offer(e);
        }
        return ans;
    }
}