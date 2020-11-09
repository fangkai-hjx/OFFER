package year2020.day1109;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class New66 {

    public static void main(String[] args) {
        New66 new66 = new New66();
        int[] array = new int[12];
        System.out.println(new66.movingCount(3, 3, 4));
    }
    // m 行 n列
    // row 行 ，cols 列

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 0 || cols < 0) return 0;
        boolean[] marked = new boolean[rows * cols];
        return move(threshold, rows, cols, 0, 0, marked);
    }

    private int move(int threshold, int rows, int cols, int i, int j, boolean[] marked) {
        int count = 0;
        int index = i * cols + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || marked[index] || (getNumberSum(i) + getNumberSum(j)) > threshold) {//!marked[row * cols + col] && digitSum(row) + digitSum(col) <= threshold
            return count;
        }
        marked[index] = true;
        count += move(threshold, rows, cols, i + 1, j, marked) +
                move(threshold, rows, cols, i - 1, j, marked) +
                move(threshold, rows, cols, i, j + 1, marked) +
                move(threshold, rows, cols, i, j - 1, marked) + 1;
        return count;//包含自己的那一个格子
    }

    private int getNumberSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
}
