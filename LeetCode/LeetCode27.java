import java.util.Arrays;

public class LeetCode27 {
    public static void main(String[] args) {
        int len;
        int[] nums;
        int val;
        // 输入：nums = [3,2,2,3], val = 3
        // 输出：2, nums = [2,2]
        nums = new int[] { 3, 2, 2, 3 };
        val = 3;
        System.out.println(Arrays.toString(nums));
        len = new Solution27_2().removeElement(nums, val);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, len)));
        System.out.println("================================================");

        // 输入：nums = [0,1,2,2,3,0,4,2], val = 2
        // 输出：5, nums = [0,1,3,0,4]
        nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        val = 2;
        System.out.println(Arrays.toString(nums));
        len = new Solution27_2().removeElement(nums, val);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, len)));
        System.out.println("================================================");
    }
}

class Solution27_1 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}

class Solution27_2 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int deleted = nums.length;
        while (index < deleted) {
            if (nums[index] == val) {
                nums[index] = nums[deleted - 1];
                deleted -= 1;
            } else {
                index++;
            }
            // System.out.println(Arrays.toString(Arrays.copyOf(nums, deleted)));
        }
        return deleted;
    }
}