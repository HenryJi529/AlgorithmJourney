import java.util.HashSet;

public class LeetCode1346 {
    public static void main(String[] args) {
        // 输入：arr = [10,2,5,3]
        // 输出：true
        System.out.println(new Solution1346().checkIfExist(new int[] { 10, 2, 5, 3 }));

        // 输入：arr = [7,1,14,11]
        // 输出：true
        System.out.println(new Solution1346().checkIfExist(new int[] { 7, 1, 14, 11 }));

        // 输入：arr = [3,1,7,11]
        // 输出：false
        System.out.println(new Solution1346().checkIfExist(new int[] { 3, 1, 7, 11 }));

        // 输入：arr = [-10,12,-20,-8,15]
        // 输出：true
        System.out.println(new Solution1346().checkIfExist(new int[] { -10, 12, -20, -8, 15 }));
    }
}

class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countZero++;
                continue;
            }
            set.add(arr[i]);
            if (set.contains(arr[i] * 2)) {
                return true;
            }
        }
        if (countZero >= 2) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] * 2)) {
                return true;
            }
        }
        return false;
    }
}