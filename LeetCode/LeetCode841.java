import java.util.List;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class LeetCode841 {
    public static void main(String[] args) {
        // 输入：rooms = [[1],[2],[3],[]]
        // 输出：true
        System.out.println(new Solution841().canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));

        // 输入：rooms = [[1,3],[3,0,1],[2],[0]]
        // 输出：false
        System.out
                .println(new Solution841()
                        .canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));

    }
}

class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        // NOTE: 可以用boolean[] 和一个额外的count降低复杂度
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Integer> keys = new LinkedList<>();
        keys.add(0);
        while (keys.size() > 0) {
            Integer cur = keys.poll();
            visited.add(cur);
            for (Integer key : rooms.get(cur)) {
                if (!visited.contains(key)) {
                    keys.add(key);
                }
            }
        }
        if (visited.size() == n) {
            return true;
        } else {
            return false;
        }
    }
}
