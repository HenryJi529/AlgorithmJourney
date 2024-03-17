import java.util.HashMap;

public class LeetCode1460 {
    public static void main(String[] args) {
        // 输入：target = [1,2,3,4], arr = [2,4,1,3]
        // 输出：true
        System.out.println(new Solution1460().canBeEqual(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 1, 3 }));

        // 输入：target = [7], arr = [7]
        // 输出：true
        System.out.println(new Solution1460().canBeEqual(new int[] { 7 }, new int[] { 7 }));

        // 输入：target = [3,7,9], arr = [3,7,11]
        // 输出：false
        System.out.println(new Solution1460().canBeEqual(new int[] { 3, 7, 9 }, new int[] { 3, 7, 11 }));

        // 输入：target = [1,2,2,3], arr = [1,1,2,3]
        // 输出：false
        System.out.println(new Solution1460().canBeEqual(new int[] { 1, 2, 2, 3 }, new int[] { 1, 1, 2, 3 }));
    }
}

class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], map.getOrDefault(target[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]) || map.get(arr[i]) == 0) {
                return false;
            }
            map.put(arr[i], map.get(arr[i]) - 1);
        }
        return true;
    }
}