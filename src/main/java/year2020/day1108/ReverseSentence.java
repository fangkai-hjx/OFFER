package year2020.day1108;

/**
 * “student. a  am I”===>“I am a student.”
 */
public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(ReverseSentence("   "));
        System.out.println("   ");
        String str = "   ";
        System.out.println("".equals(str));
    }

    public static String ReverseSentence(String str) {
        if("".equals(str.trim()) ) return str;
        StringBuilder result = new StringBuilder();
        int back = str.length() - 1;
        int font;
        while (back > 0) {
            while (back >=1 && str.charAt(back) == ' ') back--;
            font = back;
            while (font >=1 && str.charAt(font) != ' ') font--;
            String substring = str.substring(font, back+1);
            back = font;
            result.append(substring.trim()+" ");
        }
        return result.toString().trim();
    }
}
