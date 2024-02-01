public class LeetCode35 {

    public static void main(String[] args) {
        // 输入: nums = [1,3,5,6], target = 5
        // 输出: 2
        System.out.println(new Solution35().searchInsert(new int[] { 1, 3, 5, 6 }, 5));

        // 输入: nums = [1,3,5,6], target = 2
        // 输出: 1
        System.out.println(new Solution35().searchInsert(new int[] { 1, 3, 5, 6 }, 2));

        // 输入: nums = [1,3,5,6], target = 7
        // 输出: 4
        System.out.println(new Solution35().searchInsert(new int[] { 1, 3, 5, 6 }, 7));
    }

}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}