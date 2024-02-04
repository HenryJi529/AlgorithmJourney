import java.util.HashSet;
import java.util.Iterator;

public class LeetCode136 {
    public static void main(String[] args) {
        // 输入：nums = [2,2,1]
        // 输出：1
        System.out.println(new Solution136_2().singleNumber(new int[] { 2, 2, 1 }));

        // 输入：nums = [4,1,2,1,2]
        // 输出：4
        System.out.println(new Solution136_2().singleNumber(new int[] { 4, 1, 2, 1, 2 }));

        // 输入：nums = [1]
        // 输出：1
        System.out.println(new Solution136_2().singleNumber(new int[] { 1 }));

    }
}

class Solution136_1 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
}

class Solution136_2 {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
