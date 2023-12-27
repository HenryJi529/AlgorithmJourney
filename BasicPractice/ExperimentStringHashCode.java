public class ExperimentStringHashCode {
    public static void main(String[] args) {
        // 创建两个相同内容的String
        String str1 = "1234";
        String str2 = "12345".substring(0, 4);

        // 检查数组内容是否相同
        boolean contentEquals = str1.equals(str2);
        System.out.println("Content equals: " + contentEquals);

        // 检查 hashCode 是否相同
        boolean hashCodeEqualsNaive = (str1.hashCode() == str2.hashCode());
        System.out.println("HashCode equals: " + hashCodeEqualsNaive);
    }
}
