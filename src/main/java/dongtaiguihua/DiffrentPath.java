package dongtaiguihua;

/**
 * 1 建立状态转移方程
 * 2 缓存并复用以往结果
 * 3 按顺序从小往大算
 * 不同路径（困难）
 * https://leetcode-cn.com/problems/unique-paths/%20/
 * 一个机器人位于一个 m * n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class DiffrentPath {
    public static void main(String[] args) {
        DiffrentPath diffrentPath = new DiffrentPath();
        System.out.println(diffrentPath.uniquePaths(3, 3));
    }

    //状态转移方程：p(m,n) = p(m-1,n)+ p(m,n-1)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;//第一行全部为1：因为只能向下和右走
        for (int i = 0; i < n; i++) dp[0][i] = 1;//第一列全部为1：因为只能向下和右走

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
