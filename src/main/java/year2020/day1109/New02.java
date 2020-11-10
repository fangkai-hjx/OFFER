package year2020.day1109;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class New02 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));
    }
    public static String replaceSpace(StringBuffer str) {
        StringBuilder result = new StringBuilder();
        char[] chars = str.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                result.append("%20");
            }else {
                result.append(chars[i]);
            }
        }
        return result.toString();
    }
}
