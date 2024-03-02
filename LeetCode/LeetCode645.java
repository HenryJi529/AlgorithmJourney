import java.util.Arrays;

public class LeetCode645 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,2,4]
        // 输出：[2,3]
        System.out.println(Arrays.toString(new Solution645().findErrorNums(new int[] { 1, 2, 2, 4 })));
        System.out.println("================================================");

        // 输入：nums = [1,1]
        // 输出：[1,2]
        System.out.println(Arrays.toString(new Solution645().findErrorNums(new int[] { 1, 1 })));
        System.out.println("================================================");

        // 输入：nums = [3,2,3,4,6,5]
        // 输出：[3,1]
        System.out.println(Arrays.toString(new Solution645().findErrorNums(new int[] { 3, 2, 3, 4, 6, 5 })));
        System.out.println("================================================");

        // 输入：nums = [1,5,3,2,2,7,6,4,8,9]
        // 输出：[2,10]
        System.out
                .println(Arrays.toString(new Solution645().findErrorNums(new int[] { 1, 5, 3, 2, 2, 7, 6, 4, 8, 9 })));
        System.out.println("================================================");

    }
}

class Solution645 {
    public int[] findErrorNums(int[] nums) {
        boolean[] found = new boolean[nums.length + 1];
        int missing = 0;
        int repeat = 0;
        for (int i = 0; i < nums.length; i++) {
            if (found[nums[i]]) {
                repeat = nums[i];
            } else {
                found[nums[i]] = true;
            }
        }
        for (int i = 1; i < found.length; i++) {
            if (!found[i]) {
                missing = i;
                break;
            }
        }
        return new int[] { repeat, missing };
    }
}
