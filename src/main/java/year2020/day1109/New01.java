package year2020.day1109;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例1
 * 输入
 * 复制
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值
 * 复制
 * true
 */
public class New01 {
    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(Find(6, ints));
    }

    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) return false;
        int i = 0, j = array[0].length - 1;
        while (i <= array.length - 1 && j >= 0) {
            if (array[i][j] == target) return true;
            else if(array[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
