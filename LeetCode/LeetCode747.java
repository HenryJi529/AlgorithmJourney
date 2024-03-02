public class LeetCode747 {
    public static void main(String[] args) {
        // 输入：nums = [3,6,1,0]
        // 输出：1
        System.out.println(new Solution747().dominantIndex(new int[] { 3, 6, 1, 0 }));

        // 输入：nums = [1,2,3,4]
        // 输出：-1
        System.out.println(new Solution747().dominantIndex(new int[] { 1, 2, 3, 4 }));

        // 输入：nums = [1,0]
        // 输出：0
        System.out.println(new Solution747().dominantIndex(new int[] { 1, 0 }));
    }
}

class Solution747 {
    public int dominantIndex(int[] nums) {
        int firstLargestIndex, secondLargestIndex;
        if (nums[0] >= nums[1]) {
            firstLargestIndex = 0;
            secondLargestIndex = 1;
        } else {
            firstLargestIndex = 1;
            secondLargestIndex = 0;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[secondLargestIndex]) {
                if (nums[i] < nums[firstLargestIndex]) {
                    secondLargestIndex = i;
                } else {
                    secondLargestIndex = firstLargestIndex;
                    firstLargestIndex = i;
                }
            }
        }
        if (nums[firstLargestIndex] >= 2 * nums[secondLargestIndex]) {
            return firstLargestIndex;
        } else {
            return -1;
        }

    }
}