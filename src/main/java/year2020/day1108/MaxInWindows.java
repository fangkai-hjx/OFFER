package year2020.day1108;

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 * <p>
 * [4,4,6,6,6,5]
 */
public class MaxInWindows {
    public static void main(String[] args) {
        int[] ints = {10, 14, 12, 11};
        ArrayList<Integer> arrayList = maxInWindows(ints, 0);
        for (Integer integer : arrayList) {
            System.out.print(integer + "->");
        }
    }

    static public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || size == 0 || size > num.length) return result;
        int count = num.length - size + 1;//结果的个数
        for (int i = 0; i < count; i++) {
            result.add(getMax(num, i, i + size - 1));
        }
        return result;
    }

    private static Integer getMax(int[] num, int i, int j) {
        int max = num[i];
        for (int k = i; k <= j; k++) {
            if (max < num[k]) max = num[k];
        }
        return max;
    }
}
