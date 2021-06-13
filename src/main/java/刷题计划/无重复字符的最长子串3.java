package 刷题计划;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
public class 无重复字符的最长子串3 {
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)||" ".equals(s)) {
            return s.length();
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (!sb.toString().contains(String.valueOf(s.charAt(j)))) {
                    sb.append(s.charAt(j));
                    if (sb.length() > res) {
                        res = sb.length();
                    }
                }else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new 无重复字符的最长子串3().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new 无重复字符的最长子串3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new 无重复字符的最长子串3().lengthOfLongestSubstring("c"));
    }
}
