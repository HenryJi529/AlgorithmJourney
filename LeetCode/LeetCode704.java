public class LeetCode704 {
    public static void main(String[] args) {
        // 输入: nums = [-1,0,3,5,9,12], target = 9
        // 输出: 4
        System.out.println(new Solution704().search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));

        // 输入: nums = [-1,0,3,5,9,12], target = 2
        // 输出: -1
        System.out.println(new Solution704().search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
    }
}

class Solution704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}