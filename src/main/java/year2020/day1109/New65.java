package year2020.day1109;

public class New65 {
    public static void main(String[] args) {
        char[] matrix = new char[]{'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};//BCESFCSADEE
        char[] str = new char[]{'S', 'E', 'E'};
        System.out.println(new New65().hasPath(matrix, 3, 4, str));//四行 三列
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || rows <= 0 || cols <= 0 || str == null || str.length == 0)
            return false;
        boolean[] marked = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((hasPathTo(matrix, rows, cols, str, i, j, marked, 0))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathTo(char[] matrix, int rows, int cols, char[] str, int i, int j, boolean[] marked, int len) {
        int index = i * cols + j;
        //递归终止条件
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[len] || marked[index])
            return false;
        //走到str的最后一个字符了，表示有路径
        if (len == str.length - 1) {
            return true;
        }
        marked[index] = true;
        boolean b1 = hasPathTo(matrix, rows , cols, str, i-1, j, marked, len + 1);//向上
        boolean b2 = hasPathTo(matrix, rows , cols, str, i+1, j, marked, len + 1);//向下
        boolean b3 = hasPathTo(matrix, rows, cols , str, i, j-1, marked, len + 1);//向左
        boolean b4 = hasPathTo(matrix, rows, cols , str, i, j+1, marked, len + 1);//向右
        if (b1 || b2 || b3 || b4) return true;
        marked[index] = false;
        return false;
    }
}
