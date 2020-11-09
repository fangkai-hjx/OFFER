package year2020.day1029;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Exchange {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        int[] exchange = exchange(array);
        for (int i : exchange) {
            System.out.print(i + "->");
        }
    }

    /**
     * 使用快速排序的思想
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //从左向右找 找到 偶数则停止
            while (left < right && nums[left] % 2 != 0) left++;
            //从右向左找 找到 奇数则停止
            while (left < right && nums[right] % 2 == 0) right--;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
