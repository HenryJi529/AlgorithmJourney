import java.util.Arrays;

public class LeetCode26 {

    public static void main(String[] args) {
        int[] nums;
        int N;
        // 输入：nums = [1,1,2]
        // 输出：2, nums = [1,2,_]
        nums = new int[] { 1, 1, 2 };
        System.out.println(Arrays.toString(nums));
        N = new Solution26().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, N)));
        System.out.println("================================================");

        // 输入：nums = [0,0,1,1,1,2,2,3,3,4]
        // 输出：5, nums = [0,1,2,3,4]
        nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(Arrays.toString(nums));
        N = new Solution26().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, N)));
        System.out.println("================================================");
    }
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                fast++;
                slow++;
            } else {
                fast++;
            }
        }
        return slow + 1;
    }
}