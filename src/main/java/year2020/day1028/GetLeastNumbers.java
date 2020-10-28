package year2020.day1028;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] ints = {4,5,1,6,2,7,3,8};
        int[] leastNumbers = getLeastNumbers(ints, 4);
        for (int number : leastNumbers) {
            System.out.println(number);
        }
    }
    //最小的 k 个数
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length==0){
            return new int[0];
        }
        Arrays.sort(arr);
        int[] ints = Arrays.copyOf(arr, k);
        return ints;
    }
}
