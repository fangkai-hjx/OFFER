package byteDance.code2020;

import java.util.Scanner;

/**
 * 如果用户A和用户B互动不超过3次，我们就认为A和B属于豆油
 * 如果A和B是豆油，B和C也是豆油，那么A和C也互为豆油，我们定义豆油瓶就是由直系和间接朋友所组成的群体。
 * 给定一个N*N的矩阵M，代表抖音上所有用户的互动次数，如果M[i][j]=5,那么第i个和第j个用户就互动过5次，为0的话代表没有互动，
 * 其中对应i=j 表示同一个用户，互动次数我们统计为0，请你计算并且输出发现的抖音上的所有豆油瓶的个数
 */
public class douyou { //求无向连通子图个数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userNum = sc.nextInt();
        int[][] grid = new int[userNum][userNum];
        for (int i = 0; i < userNum; i++) {
            for (int j = 0; j < userNum; j++) {
                if (sc.nextInt() >= 3) {
                    grid[i][j] = 1;
                }
            }
        }                //已经遍历过的用户
        boolean[] visited = new boolean[grid.length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            if (!visited[i]) {
                res++;
                dfs(i, grid, visited);
            }
        }
        System.out.println(res);
    }

    public static void dfs(int i, int[][] grid, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < grid.length; j++) {
            if (!visited[j] && grid[i][j] == 1) {
                dfs(j, grid, visited);
            }
        }
    }
}

