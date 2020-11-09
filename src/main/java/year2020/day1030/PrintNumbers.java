package year2020.day1030;

import com.sun.org.apache.xpath.internal.operations.String;

public class PrintNumbers {
    public static void main(String[] args) {
        int[] ints = printNumbers(3);
        for (int anInt : ints) {
            System.out.print(anInt+"->");
        }
    }

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *  
     * <p>
     * 说明：
     * <p>
     * 用返回一个整数列表来代替打印
     * n 为正整数
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        StringBuilder k = new StringBuilder("1") ;
        for (int i = 0; i < n; i++) {
            k.append(0);
        }
        int w = Integer.parseInt(k.toString()) - 1;
        int[] array = new int[w];
        for (int i = 0; i < w; i++) {
            array[i] = i + 1;
        }
        return array;
    }
}
