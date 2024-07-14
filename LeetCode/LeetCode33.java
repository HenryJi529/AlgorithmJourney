public class LeetCode33 {
    public static void main(String[] args) {
        // 输入：nums = [4,5,6,7,0,1,2], target = 0
        // 输出：4
        System.out.println(new Solution33().search(new int[] { 4, 5, 6, 7, 0, 1, 2 },
                0));

        // 输入：nums = [4,5,6,7,0,1,2], target = 3
        // 输出：-1
        System.out.println(new Solution33().search(new int[] { 4, 5, 6, 7, 0, 1, 2 },
                3));

        // 输入：nums = [1], target = 0
        // 输出：-1
        System.out.println(new Solution33().search(new int[] { 1 }, 0));

        // 输入：nums = [1,3,5], target = 3
        // 输出：1
        System.out.println(new Solution33().search(new int[] { 1, 3, 5 }, 3));
    }
}

class Solution33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l < r) {
            // System.out.println(l + " " + r);
            mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            }
        }
        // System.out.println("l: " + l);
        // 此时l是第一个元素(最小元素)
        if (l == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if (target < nums[0]) {
            return binarySearch(nums, l, nums.length - 1, target);
        } else if (target > nums[0]) {
            return binarySearch(nums, 0, l - 1, target);
        } else {
            return 0;
        }
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}