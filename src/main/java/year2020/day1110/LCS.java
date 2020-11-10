package year2020.day1110;

/**
 * 最长公共子序列
 */
public class LCS {
    public static void main(String[] args) {
        System.out.println(LCS("abcde", "ace"));
        int[][] ints = buildPath("abcde", "ace");
        getLCS(5,3,ints,"abcde".toCharArray());
    }
    //构建 dp 表 ，可以 得到 最大长度信息

    //当dp[i][j]==1时，表示Xi和Yj的最长公共子序列是由Xi-1和Yj-1的最长公共子序列在尾部加上xi所得到的子序列；
    //当dp[i][j]==2时，表示Xi和Yj的最长公共子序列与Xi-1和Yj的最长公共子序列相同；
    //当dp[i][j]==3时，表示Xi和Yi的最长公共子序列与Xi和Yj-1的最长公共子序列相同。
    public static int LCS(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 获取两个串字符
                char c1 = text1.charAt(i - 1), c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    //那么输出序列呢
    public static int[][] buildPath(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] path = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char s = text1.charAt(i-1);
                char t = text1.charAt(j-1);
                if (s == t) {
                    path[i][j] = 1;
                } else if (path[i - 1][j] >= path[i][j - 1]) {// 与这里对应dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    path[i][j] = 2;
                } else {
                    path[i][j] = 3;
                }
            }
        }
        return path;
    }
    public static void getLCS(int i, int j,int[][] path,char[]str){
        if(i==0||j==0)return;
        if(path[i][j] == 1){
            getLCS(i-1,j-1,path,str);
            System.out.println(str[i]+"");
        }else if(path[i][j] == 2){
            getLCS(i-1,j,path,str);
        }else {
            getLCS(i,j-1,path,str);
        }
    }
}
