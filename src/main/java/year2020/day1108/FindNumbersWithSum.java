package year2020.day1108;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] ints = {10, 11,29,30, 31, 47, 60};
        ArrayList<Integer> list = FindNumbersWithSum(ints, 40);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length < 2) return result;
        int i = 0, j = array.length - 1;
        int tempSum = 0;
        while (i < j) {
            tempSum = array[i] + array[j];
            if (tempSum > sum) j--;
            else if (tempSum < sum) i++;
            else if (tempSum == sum) {
                result.add(array[i]);
                result.add(array[j]);
                i++;
                break;
            }
        }
        return result;
    }
}
