import java.util.Arrays;
import java.util.Comparator;

public class LeetCode435 {
    public static void main(String[] args) {
        // 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
        // 输出: 1
        System.out.println(
                new Solution435_3().eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));

        // 输入: intervals = [ [1,2], [1,2], [1,2] ]
        // 输出: 2
        System.out.println(
                new Solution435_3().eraseOverlapIntervals(new int[][] { { 1, 2 }, { 1, 2 }, {
                        1, 2 } }));

        // 输入: intervals = [ [1,2], [2,3] ]
        // 输出: 0
        System.out.println(
                new Solution435_3().eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }
                }));

        // 输入: intervals = [[1,100],[11,22],[1,11],[2,12]]
        // 输出: 2
        System.out.println(
                new Solution435_3()
                        .eraseOverlapIntervals(new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2,
                                12 } }));

        // 输入: intervals =
        // [[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
        // 输出: 7
        System.out.println(
                new Solution435_3().eraseOverlapIntervals(
                        new int[][] { { -52, 31 }, { -73, -26 }, { 82, 97 }, { -65, -11 }, { -62, -49
                        }, { 95, 99 },
                                { 58, 95 }, { -31, 49 }, { 66, 98 }, { -63, 2 }, { 30, 47 }, { -40, -26 }
                        }));
    }
}

class Solution435_1 {
    // NOTE: 此方案只能通过19/59的测试案例
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            }
        });
        System.out.println(Arrays.deepToString(intervals));
        int cur = 1;
        int pre = 0;
        int ans = 0;
        while (cur < intervals.length) {
            System.out.println(String.format("pre: %d; cur: %d", pre, cur));
            if (intervals[cur][0] < intervals[pre][1]) {
                ans++;
                cur++;
            } else {
                pre = cur;
                cur++;
            }
        }
        return ans;
    }
}

class Solution435_2 {
    // NOTE: 具体查找重叠区间
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        // System.out.println(Arrays.deepToString(intervals));
        boolean[] record = new boolean[intervals.length];
        int ans = 0;

        for (int cur = 0; cur < intervals.length; cur++) {
            if (record[cur] == true) {
                continue;
            }
            record[cur] = true;
            for (int ind = cur + 1; ind < intervals.length; ind++) {
                if (record[ind] == true) {
                    continue;
                }
                if (intervals[ind][0] < intervals[cur][1]) {
                    record[ind] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}

class Solution435_3 {
    // NOTE: 解法2的链表实现
    public class Node {
        int index;
        Node next;

        Node(int index, Node next) {
            this.index = index;
            this.next = next;
        }

        public String toString() {
            Node cur = this;
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (cur != null) {
                sb.append(cur.index);
                sb.append(',');
                cur = cur.next;
            }
            sb.append(']');
            return sb.toString();

        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        // System.out.println(Arrays.deepToString(intervals));

        int ans = 0;
        Node cur;
        Node pre;
        Node root = new Node(-1, null);
        cur = root;
        // 初始化链表
        int index = 0;
        while (index < intervals.length) {
            cur.next = new Node(index, null);
            cur = cur.next;
            index++;
        }

        Node comp = root.next;

        while (comp != null) {
            // System.out.println(root + " " + comp.index);
            pre = comp;
            cur = comp.next;
            while (cur != null) {
                if (intervals[cur.index][0] < intervals[comp.index][1]) {
                    ans++;
                    pre.next = cur.next;
                    cur = cur.next;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            comp = comp.next;
        }

        return ans;
    }
}

class Solution435_4 {
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
