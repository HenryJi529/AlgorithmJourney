import java.util.HashMap;

public class LeetCode128 {
    public static void main(String[] args) {
        // 输入：nums = [100,4,200,1,3,2]
        // 输出：4
        System.out.println(new Solution128_1().longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));

        // 输入：nums = [ 0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
        // 输出：9
        System.out.println(
                new Solution128_1().longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
    }
}

class Solution128_1 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], false);
        }
        int result = 0;
        int curr = 1;
        for (Integer item : map.keySet()) {
            if (map.get(item).equals(true)) {
                continue;
            }
            // NOTE: 这里利用了KeySet存在的不完全递增
            while (map.containsKey(++item)) {
                map.put(item, true);
                curr++;
            }
            result = Math.max(result, curr);
            curr = 1;
            // System.out.println(map);
        }
        return result;
    }
}

class Solution128_2 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }
        int result = 0;
        for (Integer currValue : map.keySet()) {
            if (map.get(currValue).equals(0)) {
                result = Math.max(result, search(nums, map, currValue));
            }
        }
        return result;
    }

    public int search(int[] nums, HashMap<Integer, Integer> map, int currValue) {
        int currCount = 1;
        int nextValue = currValue - 1;
        if (map.containsKey(nextValue)) {
            if (map.get(nextValue).equals(0)) {
                currCount += search(nums, map, nextValue);
            } else {
                currCount += map.get(nextValue);
            }
        }
        map.put(currValue, currCount);
        return currCount;
    }
}