public class LeetCode165 {
    public static void main(String[] args) {
        // 输入：version1 = "1.01", version2 = "1.001"
        // 输出：0
        System.out.println(new Solution165_2().compareVersion("1.01", "1.001"));

        // 输入：version1 = "1.0", version2 = "1.0.0"
        // 输出：0
        System.out.println(new Solution165_2().compareVersion("1.0", "1.0.0"));

        // 输入：version1 = "0.1", version2 = "1.1"
        // 输出：-1
        System.out.println(new Solution165_2().compareVersion("0.1", "1.1"));
    }
}

class Solution165_1 {
    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int i = 0;
        int v1, v2;
        while (i < Math.max(versions1.length, versions2.length)) {
            if (i < versions1.length && i >= versions2.length) {
                if (Integer.parseInt(versions1[i]) > 0) {
                    return 1;
                }
            } else if (i >= versions1.length && i < versions2.length) {
                if (Integer.parseInt(versions2[i]) > 0) {
                    return -1;
                }
            } else {
                v1 = Integer.parseInt(versions1[i]);
                v2 = Integer.parseInt(versions2[i]);
                if (v1 > v2) {
                    return 1;
                } else if (v1 < v2) {
                    return -1;
                } else {
                }
            }
            i++;
        }
        return 0;
    }
}

class Solution165_2 {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int length1 = arr1.length, length2 = arr2.length;
        int length = Math.max(length1, length2);
        for (int i = 0; i < length; i++) {
            int revision1 = i < length1 ? Integer.parseInt(arr1[i]) : 0;
            int revision2 = i < length2 ? Integer.parseInt(arr2[i]) : 0;
            if (revision1 != revision2) {
                return revision1 < revision2 ? -1 : 1;
            }
        }
        return 0;
    }
}