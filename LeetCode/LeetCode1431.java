import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1431 {
    public static void main(String[] args) {
        // 输入：candies = [2,3,5,1,3], extraCandies = 3
        // 输出：[true,true,true,false,true]
        System.out.println(Arrays
                .toString(new Solution1431().kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3).toArray(new Boolean[5])));

        // 输入：candies = [4,2,1,1,2], extraCandies = 1
        // 输出：[true,false,false,false,false]
        System.out
                .println(Arrays.toString(new Solution1431().kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1).toArray()));

        // 输入：candies = [12,1,12], extraCandies = 10
        // 输出：[true,false,true]
        System.out.println(Arrays.toString(new Solution1431().kidsWithCandies(new int[] { 12, 1, 12 }, 10).toArray()));
    }
}

class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            ans.add(candies[i] + extraCandies >= max);
        }
        return ans;
    }
}