import java.util.Arrays;

public class ExperimentDefaultValue {
    static int intValue;
    static double doubleValue;
    static boolean booleanValue;
    static char charValue;
    static String stringValue;
    static boolean[] booleanArrayValue = new boolean[10];
    static Object objectValue;

    public static void main(String[] args) {
        System.out.println("int: " + intValue);
        System.out.println("double: " + doubleValue);
        System.out.println("boolean: " + booleanValue);
        System.out.println("char: " + charValue);
        System.out.println("String: " + stringValue);
        System.out.println("booleanArray: " + Arrays.toString(booleanArrayValue));
        System.out.println("Object: " + objectValue);
    }
}
