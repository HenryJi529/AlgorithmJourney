import java.util.Arrays;

public class LeetCode80 {
    public static void main(String[] args) {
        int[] nums;
        int k;
        // 输入：nums = [1,1,1,2,2,3]
        // 输出：5, nums = [1,1,2,2,3]
        nums = new int[] { 1, 1, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(nums));
        k = new Solution80().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
        System.out.println("================================================");

        // 输入：nums = [0,0,1,1,1,1,2,3,3]
        // 输出：7, nums = [0,0,1,1,2,3,3]
        nums = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        System.out.println(Arrays.toString(nums));
        k = new Solution80().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
        System.out.println("================================================");
    }
}

class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int next = 1;
        int index = 2;
        while (index < nums.length) {
            if (nums[index] == nums[next] && nums[index] == nums[next - 1]) {
            } else {
                nums[++next] = nums[index];
            }
            index++;
        }
        return next + 1;
    }
}