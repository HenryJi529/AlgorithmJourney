import java.util.HashSet;

public class LeetCode217 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1]
        // 输出：true
        System.out.println(new Solution217().containsDuplicate(new int[] { 1, 2, 3, 1 }));

        // 输入：nums = [1,2,3,4]
        // 输出：false
        System.out.println(new Solution217().containsDuplicate(new int[] { 1, 2, 3, 4 }));

        // 输入：nums = [1,1,1,3,3,4,3,2,4,2]
        // 输出：true
        System.out.println(new Solution217().containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));

    }
}

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}