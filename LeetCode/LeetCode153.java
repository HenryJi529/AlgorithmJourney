public class LeetCode153 {
    public static void main(String[] args) {
        // 输入：nums = [3,4,5,1,2]
        // 输出：1
        System.out.println(new Solution153().findMin(new int[] { 3, 4, 5, 1, 2 }));

        // 输入：nums = [4,5,6,7,0,1,2]
        // 输出：0
        System.out.println(new Solution153().findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));

        // 输入：nums = [11,13,15,17]
        // 输出：11
        System.out.println(new Solution153().findMin(new int[] { 11, 13, 15, 17 }));
    }

}

class Solution153 {
    public int findMin(int[] nums) {
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
        return nums[l];
    }
}