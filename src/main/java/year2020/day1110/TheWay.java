package year2020.day1110;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如下面矩阵
 * <p>
 * a b t g
 * c f c s
 * j d e h
 * <p>
 * 包含一条字符串"bfce"的路径，但是矩阵中不包含"abfb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class TheWay {
    public static void main(String[] args) {
        TheWay theWay = new TheWay();
        char[] array = new char[]{
                'a', 'b', 't', 'g',
                'c', 'f', 'c', 's',
                'j', 'd', 'e', 'h'
        };
        char[] str = new char[]{'b', 'f', 'c', 'e'};
        System.out.println(theWay.hasPath(array, 3, 4, str));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || rows < 0 || cols < 0 || rows * cols != matrix.length || str.length > matrix.length)
            return false;
        boolean[] visited = new boolean[rows * cols];//用来回溯标志位
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //每个位置都有可能是起点
                if(isHasPath(matrix, rows, cols, str, visited, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean isHasPath(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int i, int j, int len) {
        //终止条件
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[index] || str[len] != matrix[index]) return false;
        if(str.length-1 == len){//最后一个节点了
            return true;
        }
        //以下代码表示 该节点满足条件也就是str[len] = matix[index],但是 未完成 全部路径
        //下一步要继续寻找路径（上下左右）
        //都不满足，下一步
        visited[index]=true;
        //len + 1 是 表示 下一个 字符
        boolean b1 = isHasPath(matrix,rows,cols,str,visited,i-1,j,len+1);//向上
        boolean b2 = isHasPath(matrix,rows,cols,str,visited,i+1,j,len+1);//向下
        boolean b3 = isHasPath(matrix,rows,cols,str,visited,i,j-1,len+1);//向左
        boolean b4 = isHasPath(matrix,rows,cols,str,visited,i,j+1,len+1);//向右
        if(b1 || b2 || b3|| b4) return true;
        visited[index]=false;//上下左右都不行--》回溯到是一个状态
        return false;
    }

}
