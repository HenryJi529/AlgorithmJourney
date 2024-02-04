public class ExperimentStringHashCode {
    public static void main(String[] args) {
        // 创建两个相同内容的String
        String str1 = "1234";
        String str2 = "12345".substring(0, 4);
        String str3 = "1234";

        // 检查数组是否相同
        System.out.println("str1 str2 Content equals: " + str1.equals(str2));
        System.out.println("str1 str3 Reference equals: " + (str1 == str2));
        System.out.println("str1 str3 Reference equals: " + (str1 == str3));

        // 检查 hashCode 是否相同
        boolean hashCodeEqualsNaive = (str1.hashCode() == str2.hashCode());
        System.out.println("HashCode equals: " + hashCodeEqualsNaive);
    }
}
