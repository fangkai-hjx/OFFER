package year2020.ALL;

/**
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class N4 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(array, 55));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if ((matrix == null || matrix.length==0) || (matrix.length==1&&matrix[0].length==0)) {
            return false;
        }
        int s = matrix[0].length - 1;//列数
        int w = 0;//行数 从第0行开始
        while (s >= 0 && w <= matrix.length - 1) {
            if (matrix[w][s] == target) return true;
            else if (matrix[w][s] > target) {//向左移动
                s--;
            } else {//向下移动
                w++;
            }
        }

        return false;
    }
}
