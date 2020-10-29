package year2020.day1029;

/**
 *找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(ints));
    }
    //利用数组的性质 长度 为 n
    public static int findRepeatNumber1(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int[] record = new int[nums.length];
        for (int num : nums) {
            record[num] ++;
        }
        for (int i = 0; i < record.length; i++) {
            if(record[i] > 1){
                return i;
            }
        }
        return -1;
    }
    public static int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[nums[i]] !=  nums[i]) swap(nums,i,nums[i]);
            if(nums[i] == nums[nums[i]] && nums[i] != i){
                return nums[i];
            }
        }
        return -1;
    }
    public static void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
