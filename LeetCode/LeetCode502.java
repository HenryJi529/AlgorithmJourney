import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public class LeetCode502 {
    public static void main(String[] args) {
        // 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
        // 输出：4
        System.out
                .println(new Solution502_2().findMaximizedCapital(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 }));

        // 输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
        // 输出：6
        System.out
                .println(new Solution502_2().findMaximizedCapital(3, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 2 }));
    }
}

class Solution502_1 {
    // NOTE: 这个版本只对profit排序，而处理capital只是使用集合，因此复杂度略高
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int N = profits.length;
        // boolean[] visited = new boolean[N];
        HashSet<Integer> unvisited = new HashSet<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer ind1, Integer ind2) {
                return profits[ind2] - profits[ind1];
            }
        });
        for (int i = 0; i < N; i++) {
            unvisited.add(i);
        }
        while (k > 0) {
            Iterator<Integer> it = unvisited.iterator();
            while (it.hasNext()) {
                int ind = it.next();
                if (capital[ind] <= w) {
                    pq.add(ind);
                    it.remove();
                }
            }
            // for (int i = 0; i < N; i++) {
            // if (visited[i]) {
            // continue;
            // }
            // if (capital[i] <= w) {
            // pq.add(i);
            // visited[i] = true;
            // }
            // }
            if (pq.isEmpty()) {
                break;
            }
            k--;
            w += profits[pq.poll()];
        }

        return w;
    }
}

class Solution502_2 {
    // NOTE: 通过对captial排序，降低查找满足capital需求的复杂度
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int curr = 0;
        int[][] list = new int[len][2];
        for (int i = 0; i < len; i++) {
            list[i][0] = profits[i];
            list[i][1] = capital[i];
        }
        Arrays.sort(list, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> que = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            while (curr < len && list[curr][1] <= w) {
                que.add(list[curr][0]);
                curr++;
            }
            if (!que.isEmpty()) {
                w += que.poll();
            } else {
                break;
            }
        }
        return w;
    }
}