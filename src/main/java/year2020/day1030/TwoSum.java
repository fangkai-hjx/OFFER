package year2020.day1030;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = {2, 7, 15};
        int[] ints1 = twoSum2(ints, 9);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

    public static int[] twoSum1(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (Integer integer : set) {
            if (set.contains(target - integer)) return new int[]{integer, target - integer};
        }
        return null;
    }

    //双指针
    public static int[] twoSum2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int s = -1;
        while (i<j){
            s = nums[i] + nums[j];
            if(s > target) j--;
            else if(s < target) i++;
            else return new int[]{nums[i],nums[j]};
        }
        return null;
    }
}
