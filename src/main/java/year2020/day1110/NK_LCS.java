package year2020.day1110;

/**
 * 题目描述
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 * 示例1
 * 输入
 * "1AB2345CD","12345EF"
 * 返回值
 * "2345"
 */
public class NK_LCS {
    public static void main(String[] args) {

    }
    public String LCS (String str1, String str2) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 1;
        while (end < str1.length() + 1){
            if (str2.contains(str1.substring(start, end))){
                if (sb.length() < end - start){
                    sb.delete(0, sb.length());//清空
                    sb.append(str1, start, end);//添加
                }
                end++;
            }
            else{
                start++;
            }
        }
        if (sb.length() == 0)
            return "-1";
        return sb.toString();
    }
}
