import java.util.Arrays;
import java.util.Comparator;

public class LeetCode179 {
    public static void main(String[] args) {
        // 输入：nums = [10,2]
        // 输出："210"
        System.out.println(new Solution179().largestNumber(new int[] { 10, 2 }));

        // 输入：nums = [3,30,34,5,9]
        // 输出："9534330"
        System.out.println(new Solution179().largestNumber(new int[] { 3, 30, 34, 5, 9 }));

        // 输入：nums = [999999991,9]
        // 输出："9999999991"
        System.out.println(new Solution179().largestNumber(new int[] { 999999991, 9 }));

        // 输入：nums = [0,0]
        // 输出："0"
        System.out.println(new Solution179().largestNumber(new int[] { 0, 0 }));
    }
}

class Solution179 {
    public String largestNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < stringNums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNums, new Comparator<>() {
            public int compare(String a, String b) {
                String first = b + a;
                String second = a + b;
                return first.compareTo(second);
            }
        });
        // System.out.println(Arrays.toString(integerNums));
        if (stringNums[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String item : stringNums) {
            sb.append(item);
        }
        return sb.toString();
    }
}