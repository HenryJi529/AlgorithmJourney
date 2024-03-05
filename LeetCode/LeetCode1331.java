import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1331 {
    public static void main(String[] args) {
        // 输入：arr = [40,10,20,30]
        // 输出：[4,1,2,3]
        System.out.println(Arrays.toString(new Solution1331().arrayRankTransform(new int[] { 40, 10, 20, 30 })));

        // 输入：arr = [100,100,100]
        // 输出：[1,1,1]
        System.out.println(Arrays.toString(new Solution1331().arrayRankTransform(new int[] { 100, 100, 100 })));

        // 输入：arr = [37,12,28,9,100,56,80,5,12]
        // 输出：[5,3,4,2,8,6,7,1,3]
        System.out.println(Arrays
                .toString(new Solution1331().arrayRankTransform(new int[] { 37, 12, 28, 9, 100, 56, 80, 5, 12 })));
    }
}

class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (!ranks.containsKey(sortedArr[i])) {
                ranks.put(sortedArr[i], rank);
                rank++;
            }
        }
        int[] result = new int[sortedArr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = ranks.get(arr[i]);
        }

        return result;
    }
}