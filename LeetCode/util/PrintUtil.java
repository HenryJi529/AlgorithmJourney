package util;

import java.util.List;

public class PrintUtil {
    public static <T> void printNestedList(List<List<T>> nestedList) {
        if (nestedList == null) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nestedList.size(); i++) {
            List<T> innerList = nestedList.get(i);
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
