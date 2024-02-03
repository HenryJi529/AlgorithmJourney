import java.util.HashSet;

public class LeetCode219 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1], k = 3
        // 输出：true
        System.out.println(new Solution219().containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));

        // 输入：nums = [1,0,1,1], k = 1
        // 输出：true
        System.out.println(new Solution219().containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));

        // 输入：nums = [1,2,3,1,2,3], k = 2
        // 输出：false
        System.out.println(new Solution219().containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));

    }
}

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
