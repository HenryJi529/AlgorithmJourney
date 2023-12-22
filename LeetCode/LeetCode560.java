import java.util.HashMap;

public class LeetCode560 {
    public static void main(String[] args) {
        // 输入：nums = [1,1,1], k = 2
        // 输出：2
        System.out.println(new Solution560().subarraySum(new int[] { 1, 1, 1 }, 2));

        // 输入：nums = [1,2,3], k = 3
        // 输出：2
        System.out.println(new Solution560().subarraySum(new int[] { 1, 2, 3 }, 3));
    }
}

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            if (nums[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int ans = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}