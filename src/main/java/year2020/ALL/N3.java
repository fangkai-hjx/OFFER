package year2020.ALL;

import java.util.HashSet;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class N3 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,2,4,1};
        System.out.println(findRepeatNumber2(array));
    }
    //时间复杂度
    public static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num) == false) {//已有重复元素
                return num;
            }
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            //在nums[i] != i的条件下只有满足nums[i] != nums[nums[i]] 该条件 才可以交换
            while (nums[i] != i && nums[i] != nums[nums[i]] ){
                swap(nums,i,nums[i]);
            }
            //只有在这种条件下 才是重复元素
            if(nums[i] == nums[nums[i]] && nums[i] != i){
                return nums[i];
            }
        }
        return -1;
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
