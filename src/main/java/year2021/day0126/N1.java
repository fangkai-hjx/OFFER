package year2021.day0126;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 7,[[1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]]
 */
public class N1 {
    public static void main(String[] args) {

    }

    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) return false;
        int i = 0;
        int j = array[0].length-1;
        while (i <= array.length - 1 && j >= 0) {
            if (target == array[i][j]) return true;
            else if (target < array[i][j]) j--;
            else i++;
        }
        return false;
    }
}
