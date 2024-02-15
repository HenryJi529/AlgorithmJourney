import java.util.HashMap;

public class LeetCode1512 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1,1,3]
        // 输出：4
        System.out.println(new Solution1512().numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));

        // 输入：nums = [1,1,1,1]
        // 输出：6
        System.out.println(new Solution1512().numIdenticalPairs(new int[] { 1, 1, 1, 1 }));

        // 输入：nums = [1,2,3]
        // 输出：0
        System.out.println(new Solution1512().numIdenticalPairs(new int[] { 1, 2, 3 }));

        // 输入：nums =
        // [6,5,1,5,7,7,9,1,5,7,1,6,10,9,7,4,1,8,7,1,1,8,6,4,7,4,10,5,3,9,10,1,9,5,5,4,1,7,4,2,9,2,6,6,4,2,10,3,5,3,6,4,7,4,6,4,4,6,3,4,10,1,10,6,10,4,9,6,6,4,8,6,9,5,4]
        // 输出：303
        System.out.println(new Solution1512().numIdenticalPairs(new int[] { 6, 5, 1, 5, 7, 7, 9, 1, 5, 7, 1, 6, 10, 9,
                7, 4, 1, 8, 7, 1, 1, 8, 6, 4, 7, 4, 10, 5, 3, 9, 10, 1, 9, 5, 5, 4, 1, 7, 4, 2, 9, 2, 6, 6, 4, 2, 10, 3,
                5, 3, 6, 4, 7, 4, 6, 4, 4, 6, 3, 4, 10, 1, 10, 6, 10, 4, 9, 6, 6, 4, 8, 6, 9, 5, 4 }));
    }
}

class Solution1512 {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            ans += map.get(key) * (map.get(key) - 1) / 2;
        }
        return ans;
    }
}