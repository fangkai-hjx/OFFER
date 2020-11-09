package year2020.day1108;

public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 1, 2, 3, 4, 5, 7, 6, 7, 6, 8};//5 8
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res ^= array[i];
        }
        //1 将相同的数字分到一组
        //2 将那两个数字分到不同组
        int div = 1;
        while ((res & 1) == 0) {//取出最后一个为1的数字
            div = div << 1;
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & div) == 0) {//指定位数的数 为0
                num1[0] = num1[0] ^ array[i];
            } else {//指定位数的数 为0
                num2[0] = num2[0] ^ array[i];
            }
        }
        return;
    }
}
