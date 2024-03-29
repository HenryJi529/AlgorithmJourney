import java.util.PriorityQueue;

public class LeetCode1642 {
    public static void main(String[] args) {
        // 输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
        // 输出：4
        // 解释：从建筑物 0 出发，你可以按此方案完成旅程：
        // - 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
        // - 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
        // - 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
        // - 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
        // 无法越过建筑物 4 ，因为没有更多砖块或梯子。
        System.out.println(new Solution1642().furthestBuilding(new int[] { 4, 2, 7,
                6, 9, 14, 12 }, 5, 1));

        // 输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
        // 输出：7
        System.out.println(new Solution1642().furthestBuilding(new int[] { 4, 12, 2,
                7, 3, 18, 20, 3, 19 }, 10, 2));

        // 输入：heights = [14,3,19,3], bricks = 17, ladders = 0
        // 输出：3
        System.out.println(new Solution1642().furthestBuilding(new int[] { 14, 3, 19,
                3 }, 17, 0));

    }
}

class Solution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int furthest = 0;
        int leftBricks = bricks;
        int leftLadders = ladders;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 1; i < heights.length; i++) {
            int needBricks = heights[i] - heights[i - 1];
            if (needBricks <= 0) {
                // System.out.println(String.format("从%d楼到%d楼[%d -> %d]: 不消耗砖块 【梯: %d, 砖: %d】",
                // i - 1, i, heights[i - 1],
                // heights[i], leftLadders, leftBricks));
                furthest++;
            } else {
                if (needBricks <= leftBricks) {
                    leftBricks -= needBricks;
                    queue.add(-needBricks);
                    // System.out.println(String.format("从%d楼到%d楼[%d -> %d]: 消耗%d砖块 【梯: %d, 砖: %d】",
                    // i - 1, i,
                    // heights[i - 1], heights[i],
                    // needBricks, leftLadders, leftBricks));
                    furthest++;
                } else {
                    // 如果剩余砖块不够
                    if (leftLadders > 0) {
                        // 还有梯子
                        queue.add(-needBricks);
                        int maxBrickConsume = -queue.poll();
                        leftBricks += maxBrickConsume;
                        leftBricks -= needBricks;
                        leftLadders--;
                        furthest++;
                        // System.out.println(String.format("从%d楼到%d楼[%d -> %d]: 使用梯子 【梯: %d, 砖: %d】", i
                        // - 1, i,
                        // heights[i - 1], heights[i], leftLadders, leftBricks));
                    } else {
                        // 梯子都没了
                        break;
                    }
                }
            }
        }
        return furthest;
    }
}