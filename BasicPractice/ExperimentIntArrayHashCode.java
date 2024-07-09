import java.util.Arrays;

public class ExperimentIntArrayHashCode {
    public static void main(String[] args) {
        // 创建两个相同内容的 int[] 数组
        int[] array1 = new int[] { 1, 2, 3 };
        int[] array2 = Arrays.copyOf(array1, array1.length);
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));

        // 检查数组内容是否相同
        boolean contentEquals = Arrays.equals(array1, array2);
        System.out.println("Content equals: " + contentEquals);

        // 检查 hashCode 是否相同
        boolean hashCodeEqualsArray = (Arrays.hashCode(array1) == Arrays.hashCode(array2));
        System.out.println("ArrayHashCode equals: " + hashCodeEqualsArray);
        boolean hashCodeEqualsNaive = (array1.hashCode() == array2.hashCode());
        System.out.println("NaiveHashCode equals: " + hashCodeEqualsNaive);
    }
}
