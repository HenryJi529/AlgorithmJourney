import java.util.Arrays;

public class LeetCode1470 {
    public static void main(String[] args) {
        // 输入：nums = [2,5,1,3,4,7], n = 3
        // 输出：[2,3,5,4,1,7]
        System.out.println(Arrays.toString(new Solution1470().shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));

        // 输入：nums = [1,2,3,4,4,3,2,1], n = 4
        // 输出：[1,4,2,3,3,2,4,1]
        System.out.println(Arrays.toString(new Solution1470().shuffle(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4)));

        // 输入：nums = [1,1,2,2], n = 2
        // 输出：[1,2,1,2]
        System.out.println(Arrays.toString(new Solution1470().shuffle(new int[] { 1, 1, 2, 2 }, 2)));
    }
}

class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] newNums = new int[2 * n];
        int left = 0;
        int right = n;
        int index = 0;
        while (index < nums.length) {
            newNums[index] = nums[left++];
            newNums[index + 1] = nums[right++];
            index += 2;
        }
        return newNums;
    }
}