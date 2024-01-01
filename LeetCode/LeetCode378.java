import java.util.PriorityQueue;
import java.util.Comparator;

public class LeetCode378 {
    public static void main(String[] args) {
        // 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
        // 输出：13
        System.out
                .println(new Solution378().kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));

        // 输入：matrix = [[-5]], k = 1
        // 输出：-5
        System.out
                .println(new Solution378().kthSmallest(new int[][] { { -5 } }, 1));
    }
}

class Solution378 {
    class Cell {
        int i;
        int j;

        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                int val1 = matrix[c1.i][c1.j];
                int val2 = matrix[c2.i][c2.j];
                if (val1 < val2) {
                    return -1;
                } else if (val1 > val2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new Cell(i, 0));
        }
        Cell cur;
        while (true) {
            cur = pq.poll();
            k--;
            if (k == 0) {
                break;
            }
            if (cur.j <= n - 2) {
                pq.offer(new Cell(cur.i, cur.j + 1));
            }
        }
        return matrix[cur.i][cur.j];
    }
}