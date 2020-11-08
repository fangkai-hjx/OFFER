package year2020.day1106;


import java.util.*;

//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
// 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str == null && str.length() == 0) return -1;
        char[] chars = str.toCharArray();
        LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (countMap.containsKey(chars[i])) {
                countMap.replace(chars[i], countMap.get(chars[i]) + 1);
            } else {
                countMap.put(chars[i], 1);
            }
        }
        for (Character character : countMap.keySet()) {
            if(countMap.get(character) == 1){
                return str.indexOf(character);
            }
        }
        return -1;
    }
}
