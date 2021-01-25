package year2021;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 1 5   9  13  17
 * 4 8  12  15  20
 * 6 10 14  17  22
 */
public class NK01 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("a b");
        System.out.println(a.toString().replace(" ", "%20"));
    }

    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) {
            return false;
        }
        int row = 0;
        int line = array[0].length - 1;
        while (row <= array.length-1 && line>=0){
            if (target == array[row][line]) return true;
            else if (target > array[row][line]) row++;
            else line--;
        }
        return false;
    }
}
