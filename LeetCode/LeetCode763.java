import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode763 {
    public static void main(String[] args) {
        // 输入：s = "ababcbacadefegdehijhklij"
        // 输出：[9,7,8]
        System.out.println(Arrays.toString(new Solution763_2().partitionLabels("ababcbacadefegdehijhklij").toArray()));

        // 输入：s = "eccbbbbdec"
        // 输出：[10]
        System.out.println(Arrays.toString(new Solution763_2().partitionLabels("eccbbbbdec").toArray()));
    }
}

/**
 * 整体思路没问题，但区间结合上复杂度较高【区间合并的思路不够清晰】
 */
class Solution763_1 {
    public List<Integer> partitionLabels(String s) {
        int[][] counts = new int[26][2]; // 存储a-z出现的最早和最晚位置
        for (int i = 0; i < counts.length; i++) {
            counts[i][0] = -1;
            counts[i][1] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if (counts[ind][0] == -1) {
                // 还未出现过对应字母
                counts[ind][0] = i;
                counts[ind][1] = i;
            } else {
                if (counts[ind][1] < i) {
                    counts[ind][1] = i;
                }
            }
        }
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i][0] == -1) {
                continue;
            }
            intervals.add(new int[] { counts[i][0], counts[i][1] });
        }
        Collections.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        // System.out.println(Arrays.deepToString(intervals.toArray(new
        // int[intervals.size()][2])));
        List<Integer> starts = new ArrayList<>();
        // System.out.println(Arrays.toString(starts.toArray()));
        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i)[0];
            int end = intervals.get(i)[1];
            // System.out.println(start + " " + end);
            int ind = 0;
            while (ind < starts.size() && start > starts.get(ind)) {
                ind++;
            }
            if (ind == starts.size()) {
                starts.add(start);
                starts.add(end + 1);
            } else {
                if (starts.get(ind) == start) {
                    ind++;
                }
                while (ind < starts.size() && starts.get(ind) <= end) {
                    starts.remove(ind);
                }
                if (ind == starts.size()) {
                    starts.add(end + 1);
                }
            }
            // System.out.println(Arrays.toString(starts.toArray()));
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < starts.size(); i++) {
            result.add(starts.get(i) - starts.get(i - 1));
        }
        return result;
    }
}

/**
 * 直接删除重复的区间，复杂度有所降低
 */
class Solution763_2 {
    public List<Integer> partitionLabels(String s) {
        int[][] counts = new int[26][2]; // 存储a-z出现的最早和最晚位置
        for (int i = 0; i < counts.length; i++) {
            counts[i][0] = -1;
            counts[i][1] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if (counts[ind][0] == -1) {
                // 还未出现过对应字母
                counts[ind][0] = i;
                counts[ind][1] = i;
            } else {
                if (counts[ind][1] < i) {
                    counts[ind][1] = i;
                }
            }
        }
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i][0] == -1) {
                continue;
            }
            intervals.add(new int[] { counts[i][0], counts[i][1] });
        }
        Collections.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        // System.out.println(Arrays.deepToString(intervals.toArray(new
        // int[intervals.size()][2])));
        int curr = 0;
        int next = 1;
        while (next < intervals.size()) {
            if (intervals.get(curr)[1] >= intervals.get(next)[0]) {
                if (intervals.get(curr)[1] < intervals.get(next)[1]) {
                    intervals.get(curr)[1] = intervals.get(next)[1];
                }
                intervals.remove(next);
            } else {
                curr++;
                next++;
            }
        }
        // System.out.println(Arrays.deepToString(intervals.toArray(new
        // int[intervals.size()][2])));
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < intervals.size(); i++) {
            result.add(intervals.get(i)[1] - intervals.get(i)[0] + 1);
        }
        return result;
    }
}

/**
 * 可以直接记录区间最大值用来更新区间的边界
 */
class Solution763_3 {
    public List<Integer> partitionLabels(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i; // 每个字母最后出现的下标
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s[i] - 'a']); // 更新当前区间右端点的最大值
            if (end == i) { // 当前区间合并完毕
                ans.add(end - start + 1); // 区间长度加入答案
                start = i + 1; // 下一个区间的左端点
            }
        }
        return ans;
    }
}
