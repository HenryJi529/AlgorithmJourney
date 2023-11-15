package util;

import java.util.List;

public class PrintUtil {
    public static void printNestedArray(List<List<Integer>> nestedList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nestedList.size(); i++) {
            List<Integer> innerList = nestedList.get(i);
            sb.append("[");
            for (int j = 0; j < innerList.size(); j++) {
                sb.append(innerList.get(j));
                if (j != innerList.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (i != nestedList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
