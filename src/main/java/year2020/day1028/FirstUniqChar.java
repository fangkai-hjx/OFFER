package year2020.day1028;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "";
        char c = firstUniqChar(s);
        System.out.println(c);
    }
    public static char firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                Integer integer = map.get(s.charAt(i));
                map.put(s.charAt(i),++integer);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        char ss = ' ';
        for (Character character : map.keySet()) {
            Integer integer = map.get(character);
            if(integer == 1){
                ss = character;
                break;
            }
        }
        return ss;
    }
}
