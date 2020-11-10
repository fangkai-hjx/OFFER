package year2020.day1110;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Robot {
    public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println(robot.movingCount(3, 3, 4));
    }

    //他的移动位置的坐标每个数字之和 不能 超过 threshold
    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 0 || cols < 0 || threshold < 0) return 0;
        boolean[] marked = new boolean[rows * cols];
        return move(threshold, rows, cols, marked, 0, 0);//从(0,0)开始
    }

    // (i,j)
    private int move(int threshold, int rows, int cols, boolean[] marked, int i, int j) {
        //递归终止条件
        int count = 0;
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || marked[index] || (getNumberSum(i) + getNumberSum(j)) > threshold){
            if(i<0) System.out.println("向上边走不行");
            else if(i>=rows) System.out.println("向下边走不行");
            else if(j < 0) System.out.println("向左边走不行");
            else if(j >= cols) System.out.println("向右边走不行");
            else if(marked[index]) System.out.println("该位置已经被标志了");
            else if((getNumberSum(i) + getNumberSum(j)) > threshold) System.out.println("超过门限值");
            return count;
        }
        System.out.println("正常走了一步:("+i+","+j+")");
        //开始查找
        marked[index] =true;//访问index位置，也就是(i,j)
        count +=move(threshold,rows,cols,marked,i-1,j);//向上
        count +=move(threshold,rows,cols,marked,i,j-1);//向左
        count +=move(threshold,rows,cols,marked,i+1,j);//向下
        count +=move(threshold,rows,cols,marked,i,j+1)+1;//向右+自己本身
        marked[index] =false;//访问index位置，也就是(i,j)
        System.out.println("这是成功"+count);
        return count;
    }

    private int getNumberSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
    /**
     * 这是终止条件0---向左
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是成功1
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是成功1
     * 这是成功3
     * 这是成功4
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是成功5
     * 这是终止条件0
     * 这是终止条件0
     * 这是终止条件0
     * 这是成功6
     * 这是成功7
     * 这是终止条件0
     * 这是终止条件0
     * 这是成功8
     * 这是终止条件0
     * 这是终止条件0
     * 这是成功9
     */
}
