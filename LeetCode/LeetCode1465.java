import java.util.Arrays;

public class LeetCode1465 {
    public static void main(String[] args) {
        // 输入：h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
        // 输出：4
        System.out.println(new Solution1465().maxArea(5, 4, new int[] { 1, 2, 4 }, new int[] { 1, 3 }));

        // 输入：h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
        // 输出：6
        System.out.println(new Solution1465().maxArea(5, 4, new int[] { 3, 1 }, new int[] { 1 }));

        // 输入：h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
        // 输出：9
        System.out.println(new Solution1465().maxArea(5, 4, new int[] { 3 }, new int[] { 3 }));

    }
}

class Solution1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int hCutMax = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            hCutMax = Math.max(hCutMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        hCutMax = Math.max(hCutMax, h - horizontalCuts[horizontalCuts.length - 1]);

        int vCutMax = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; i++) {
            vCutMax = Math.max(vCutMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        vCutMax = Math.max(vCutMax, w - verticalCuts[verticalCuts.length - 1]);

        return (int) (((long) vCutMax * hCutMax) % (int) (1e9 + 7));
    }
}