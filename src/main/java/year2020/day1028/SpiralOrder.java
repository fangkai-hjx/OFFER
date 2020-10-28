package year2020.day1028;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] arrays = new int[][]{
                {2,5,8},{4,0,-1}};
        int[] ints = spiralOrder(arrays);
        for (int anInt : ints) {
            System.out.print(anInt+"->");
        }
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        int num = 0;
        int[] arrays = new int[(right + 1) * (down + 1)];
        while (true) {
            //从左到右
            for (int i = left; i <= right; i++) {
                arrays[num++] = matrix[up][i];
            }//走完 准备往下,验证能不能向下
            if (++up > down) break;//不能向下则跳出
            //从上到下
            for (int i = up; i <= down; i++) {
                arrays[num++] = matrix[i][right];
            }//走完准备往右，验证能不能向右
            if (--right < left) break;//不能向右则跳出
            //从右到左
            for (int i = right; i >= left; i--) {
                arrays[num++] = matrix[down][i];
            }//走完 准备往上，验证 能不能 向上
            if (--down < up) break;//不能向右则跳出
            //从下到上
            for (int i = down; i >= up; i--) {
                arrays[num++] = matrix[i][left];
            }//走完 准备往右，验证 能不能 向右
            if (++left > right) break;//不能向左则跳出
        }
        return arrays;
    }
}
