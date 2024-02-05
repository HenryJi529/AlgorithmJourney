import java.util.HashMap;

public class LeetCode169 {
    public static void main(String[] args) {
        // 输入：nums = [3,2,3]
        // 输出：3
        System.out.println(new Solution169().majorityElement(new int[] { 3, 2, 3 }));

        // 输入：nums = [2,2,1,1,1,2,2]
        // 输出：2
        System.out.println(new Solution169().majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
    }
}

class Solution169 {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int half = length / 2 + length % 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) + length - i >= half) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.remove(nums[i]);
                }
            } else {
                if (length - i >= half) {
                    map.put(nums[i], 1);
                }
            }
        }
        for (Integer item : map.keySet()) {
            if (map.get(item) >= half) {
                return item.intValue();
            }
        }
        return -1;
    }
}