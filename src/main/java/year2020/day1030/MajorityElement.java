package year2020.day1030;

import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * <p>
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]  length = 9  5
 * 输出: 2
 * <p>
 * 1, 2, 2, 2 2 3 2 4,  5
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 */
public class MajorityElement {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        if (nums == null && nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);//排序
        return nums[nums.length / 2];
    }

    public static int majorityElement2(int[] nums) {
        //记录相同数字出现的次数
//        1, 2, 3, 2, 2, 2, 5, 4, 2
        //   val = -1   cnt = 0
        // 1 val = 1  cnt = 1
        // 2 val = 2  cnt = 1
        // 3 val = 3  cnt = 0
        int val = -1, cnt = 0;
        for (int num : nums) {
            if (num == val) {
                cnt++;
            } else {      // val = 3，cnt =2
                if (cnt >= 1) { // 2 2 1 3 3 1 1
                    cnt--;
                } else {
                    val = num;
                    cnt = 1;
                }
            }
        }
        return val;
    }
}
