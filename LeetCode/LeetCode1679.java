import java.util.HashMap;

public class LeetCode1679 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3,4], k = 5
        // 输出：2
        System.out.println(new Solution1679().maxOperations(new int[] { 1, 2, 3, 4 }, 5));

        // 输入：nums = [3,1,3,4,3], k = 6
        // 输出：1
        System.out.println(new Solution1679().maxOperations(new int[] { 3, 1, 3, 4, 3 }, 6));
    }
}

class Solution1679 {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i])) {
                if (map.get(k - nums[i]) == 1) {
                    map.remove(k - nums[i]);
                } else {
                    map.put(k - nums[i], map.get(k - nums[i]) - 1);
                }
                ans++;
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return ans;
    }
}