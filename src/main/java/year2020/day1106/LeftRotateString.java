package year2020.day1106;

public class LeftRotateString {
    public static void main(String[] args) {
        LeftRotateString("abcXYZdef",3);
    }
    public static String LeftRotateString(String str,int n) {
        //abc  XYZdef
        String font = str.substring(0, n);
        StringBuilder result = new StringBuilder(str.substring(n)).append(font);
        return result.toString();
    }
}
