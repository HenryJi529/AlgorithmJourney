public class LeetCode1710 {
    public static void main(String[] args) {
        // 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
        // 输出：8
        System.out.println(new Solution1710().maximumUnits(new int[][] { { 1, 3 }, { 2, 2 }, { 3, 1 } }, 4));

        // 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
        // 输出：91
        System.out
                .println(new Solution1710().maximumUnits(new int[][] { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } }, 10));

    }
}

class Solution1710 {
    // 这种解法适用于truckSize较小的情况
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        int maxNumberOfUnitsPerBox;
        int index;
        while (truckSize > 0) {
            maxNumberOfUnitsPerBox = 0;
            index = -1;
            for (int i = 0; i < boxTypes.length; i++) {
                if (boxTypes[i][0] != 0) {
                    if (maxNumberOfUnitsPerBox < boxTypes[i][1]) {
                        maxNumberOfUnitsPerBox = boxTypes[i][1];
                        index = i;
                    }
                }
            }
            if (index == -1) {
                break;
            }
            if (boxTypes[index][0] < truckSize) {
                truckSize -= boxTypes[index][0];
                ans += boxTypes[index][1] * boxTypes[index][0];
                boxTypes[index][0] = 0;
            } else if (boxTypes[index][0] >= truckSize) {
                ans += truckSize * boxTypes[index][1];
                break;
            }
        }
        return ans;
    }
}