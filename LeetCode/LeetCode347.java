import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode347 {
    public static void main(String[] args) {
        // 输入: nums = [1,1,1,2,2,3], k = 2
        // 输出: [1,2]
        System.out.println(Arrays.toString(new Solution347().topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));

        // 输入: nums = [1], k = 1
        // 输出: [1]
        System.out.println(Arrays.toString(new Solution347().topKFrequent(new int[] { 1 }, 1)));

    }
}

class Solution347 {
    private class Item implements Comparable<Item> {
        int key;
        int value;

        public Item(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int compareTo(Item other) {
            if (this.value > other.value) {
                return 1;
            } else if (this.value < other.value) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Item> pq = new PriorityQueue<Item>();
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Item(key, map.get(key)));
            } else {
                if (pq.peek().value < map.get(key)) {
                    pq.poll();
                    pq.add(new Item(key, map.get(key)));
                }
            }
        }
        Object[] arr = pq.toArray();
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = ((Item) arr[i]).key;
        }
        return res;
    }
}