package year2020.day1030;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(15);
    }

    public static int[][] findContinuousSequence(int target) {
        int[] array = new int[target];
        for (int i1 = 0; i1 < array.length; i1++) {
            array[i1] = i1+1;
        }
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0, sum = 0;
        while (i < target / 2) {
            if((array[i] + array[j]) * (j -i + 1 ) / 2 < target)j++;
            else if((array[i] + array[j]) * (j -i + 1 ) / 2 > target)i++;
            else {
                int[] one = new int[j-i+1];
                for (int i1 = 0,w=i; i1 < one.length; i1++) {
                    one[i1] = array[w++];
                }
                list.add(one);
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
