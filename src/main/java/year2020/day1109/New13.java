package year2020.day1109;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class New13 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 5, 6, 7};
        New13 new13 = new New13();
        new13.reOrderArray1(array);
        for (int number : array) {
            System.out.print(number + "->");
        }
    }

    //要求 前后顺序没变
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) return;
        int i = 0, j = 0;
        while (j < array.length) {
            //找到 右边 第一个 偶数的位置
            while (i < array.length && array[i] % 2 != 0) i++;
            j = i + 1;//j从i+1开始，因为i之前全是奇数了
            while (j < array.length && array[j] % 2 == 0) j++;//找到奇数
            if (j < array.length) {
                int temp = array[j];
                for (int k = j; k > i; k--) array[k] = array[k - 1];//将偶数整体向右移动
                array[i] = temp;//将奇数 放在 其  左边
            }
        }
    }

    //不要求前后顺序没变
    public void reOrderArray1(int[] array) {
        if (array == null || array.length == 0) return;
        int i = 0, j = array.length - 1;
        while (i < j) {
            while (i < j && array[i] % 2 != 0) i++;//从左向右 找到第一个偶数
            while (i < j && array[j] % 2 == 0) j--;//从右向左，找到第一个奇数
            //交换他们的位置
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}
