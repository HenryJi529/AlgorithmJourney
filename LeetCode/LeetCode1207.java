import java.util.HashMap;
import java.util.HashSet;

public class LeetCode1207 {
    public static void main(String[] args) {
        // 输入：arr = [1,2,2,1,1,3]
        // 输出：true
        System.out.println(new Solution1207().uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));

        // 输入：arr = [1,2]
        // 输出：false
        System.out.println(new Solution1207().uniqueOccurrences(new int[] { 1, 2 }));

        // 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
        // 输出：true
        System.out.println(new Solution1207().uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }));
    }
}

class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> records = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            records.put(arr[i], records.getOrDefault(arr[i], 0) + 1);
        }
        HashSet<Integer> counts = new HashSet<>(records.values());
        return counts.size() == records.size();
    }
}