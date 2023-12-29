import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashSet;

import util.PrintUtil;

public class LeetCode373 {
    public static void main(String[] args) {
        // 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        // 输出: [1,2],[1,4],[1,6]
        // 解释: 返回序列中的前 3 对数：
        // [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
        PrintUtil.printNestedList(new Solution373().kSmallestPairs(new int[] { 1, 7,
                11 }, new int[] { 2, 4, 6 }, 3));

        // 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
        // 输出: [1,1],[1,1]
        // 解释: 返回序列中的前 2 对数：
        // [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
        PrintUtil.printNestedList(new Solution373().kSmallestPairs(new int[] { 1, 1,
                2 }, new int[] { 1, 2, 3 }, 2));

        // 输入: nums1 = [1,2], nums2 = [3], k = 3
        // 输出: [1,3],[2,3]
        // 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
        PrintUtil.printNestedList(new Solution373().kSmallestPairs(new int[] { 1, 2
        }, new int[] { 3 }, 2));

        // 输入: nums1 = [1,2,4,5,6], nums2 = [3,5,7,9], k = 3
        // 输出: [1,3],[2,3],[1,5]
        PrintUtil.printNestedList(
                new Solution373().kSmallestPairs(new int[] { 1, 2, 4, 5, 6 }, new int[] { 3,
                        5, 7, 9 }, 3));

        // 输入: nums1 = [1,2,4,5,6], nums2 = [3,5,7,9], k = 20
        // 输出:
        // [1,3],[2,3],[1,5],[2,5],[4,3],[1,7],[5,3],[2,7],[4,5],[6,3],[1,9],[5,5],[2,9],[4,7],[6,5],[5,7],[4,9],[6,7],[5,9],[6,9]
        PrintUtil.printNestedList(
                new Solution373().kSmallestPairs(new int[] { 1, 2, 4, 5, 6 }, new int[] { 3,
                        5, 7, 9 }, 20));

    }
}

class Solution373 {
    class Item implements Comparable<Item> {
        int p1;
        int p2;
        int val;

        Item(int p1, int p2, int val) {
            this.p1 = p1;
            this.p2 = p2;
            this.val = val;
        }

        public int compareTo(Item other) {
            if (this.val < other.val) {
                return -1;
            } else if (this.val > other.val) {
                return 1;
            } else {
                return 0;
            }
        }

        public String toString() {
            return String.format("{p1=%d, p2=%d, val=%d}", p1, p2, val);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<String> visited = new HashSet<String>();

        PriorityQueue<Item> pq = new PriorityQueue<>();
        pq.offer(new Item(0, 0, nums1[0] + nums2[0]));
        visited.add(String.format("%d-%d", 0, 0));
        int ind = 0;
        while (ind < k) {
            // System.out.println(Arrays.toString(pq.toArray()));
            // System.out.println(visited);
            Item cur = pq.poll();
            res.add(List.of(nums1[cur.p1], nums2[cur.p2]));

            if (cur.p1 + 1 < nums1.length && !visited.contains(String.format("%d-%d", cur.p1 + 1, cur.p2))) {
                pq.offer(new Item(cur.p1 + 1, cur.p2, nums1[cur.p1 + 1] + nums2[cur.p2]));
                visited.add(String.format("%d-%d", cur.p1 + 1, cur.p2));
            }
            if (cur.p2 + 1 < nums2.length && !visited.contains(String.format("%d-%d", cur.p1, cur.p2 + 1))) {
                pq.offer(new Item(cur.p1, cur.p2 + 1, nums1[cur.p1] + nums2[cur.p2 + 1]));
                visited.add(String.format("%d-%d", cur.p1, cur.p2 + 1));
            }

            ind++;
        }
        return res;
    }
}