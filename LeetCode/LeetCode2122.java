import java.util.Arrays;

public class LeetCode2122 {
    public static void main(String[] args) {
        // 输入：nums = [2,10,6,4,8,12]
        // 输出：[3,7,11]
        System.out.println(Arrays.toString(new Solution2122().recoverArray(new int[] { 2, 10, 6, 4, 8, 12 })));

        // 输入：nums = [1,1,3,3]
        // 输出：[2,2]
        System.out.println(Arrays.toString(new Solution2122().recoverArray(new int[] { 1, 1, 3, 3 })));

        // 输入：nums = [5,435]
        // 输出：[220]
        System.out.println(Arrays.toString(new Solution2122().recoverArray(new int[] { 5, 435 })));

        // 输入：nums = [1,3,4,5,6,7]
        // 输出：[2,5,6]
        System.out.println(Arrays.toString(new Solution2122().recoverArray(new int[] { 1, 3, 4, 5, 6, 7 })));

        // 输入：nums = [8,4,5,1,9,8,6,5,6,9,7,3,8,3,6,7,10,11,6,4]
        // 输出：[2,4,5,5,6,7,7,8,9,10]
        System.out.println(Arrays.toString(new Solution2122()
                .recoverArray(new int[] { 8, 4, 5, 1, 9, 8, 6, 5, 6, 9, 7, 3, 8, 3, 6, 7, 10,
                        11, 6, 4 })));

        // 输入：nums = [1,50,99,101,150,199]
        // 输出：[51, 100, 149]
        System.out.println(Arrays.toString(new Solution2122()
                .recoverArray(new int[] { 1, 50, 99, 101, 150, 199 })));
    }
}

class Solution2122 {
    public int[] recoverArray(int[] nums) {
        if (nums.length == 2) {
            return new int[] { (nums[0] + nums[1]) / 2 };
        }
        int N = nums.length;
        int half = N / 2;
        int[] result;
        boolean[] visited;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        for (int firstRight = 1; firstRight <= half; firstRight++) {
            if ((nums[firstRight] - nums[0]) % 2 != 0 || nums[firstRight] - nums[0] == 0) {
                continue;
            }

            int k = (nums[firstRight] - nums[0]) >> 1;
            result = new int[half];
            int left = 0;
            int right = firstRight;
            visited = new boolean[N];
            visited[left] = true;
            visited[right] = true;
            result[0] = (nums[left] + nums[right]) >> 1;
            int ind = 1;// NOTE: 下一对的索引，也可以理解为已经处理好的对数
            // System.out.println("k: " + k);
            while (true) {
                do {
                    left++;
                } while (left < N - 1 && visited[left]);
                // NOTE: 这里不跳出，下一个循环也必然跳出
                // if (left == N - 1) {
                // break;
                // }
                right = left + 1;
                while (right != N && (visited[right] || nums[right] - nums[left] != 2 * k)) {
                    right++;
                    if (half < right - ind) {
                        break;
                    }
                }
                if (half < right - ind) {
                    // NOTE: 表示当前k确定不行了
                    break;
                }
                if (right == N) {
                    break;
                }
                result[ind] = (nums[left] + nums[right]) >> 1;
                visited[left] = true;
                visited[right] = true;
                ind++;
                // System.out.println(Arrays.toString(visited));
                // System.out.println(Arrays.toString(nums));
                // System.out.println(Arrays.toString(result));
                if (ind == half) {
                    return result;
                }
            }
        }
        return null;
    }
}
