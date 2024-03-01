import java.util.Arrays;
import java.util.HashMap;

public class LeetCode506 {
    public static void main(String[] args) {
        // 输入：score = [5,4,3,2,1]
        // 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
        // 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
        System.out.println(Arrays.toString(new Solution506().findRelativeRanks(new int[] { 5, 4, 3, 2, 1 })));

        // 输入：score = [10,3,8,9,4]
        // 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
        // 解释：名次为 [1st, 5th, 3rd, 2nd, 4th]
        System.out.println(Arrays.toString(new Solution506().findRelativeRanks(new int[] { 10, 3, 8, 9, 4 })));
    }
}

class Solution506 {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        int[] order = Arrays.copyOf(score, score.length);
        Arrays.sort(order);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            map.put(order[i], order.length - i);
        }
        for (int i = 0; i < score.length; i++) {
            int rank = map.get(score[i]);
            if (rank == 1) {
                result[i] = "Gold Medal";
            } else if (rank == 2) {
                result[i] = "Silver Medal";
            } else if (rank == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(rank);
            }
        }
        return result;
    }
}