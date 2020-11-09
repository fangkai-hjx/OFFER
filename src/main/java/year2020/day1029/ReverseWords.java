package year2020.day1029;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {
    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder str = new StringBuilder();
        int end = s.length() - 1, start = end;
        while (end >= 0) {
            while (start >= 0 && s.charAt(start) != ' ') start--;//找到空格
            str.append(s.substring(start+1, end+1)+" ");
            while (start >= 0 && s.charAt(start) == ' ') start--;//跳过空格
            end = start;
        }
        return str.toString().trim();
    }
}
