package year2020.day1027;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class MissingNumber {
    public static void main(String[] args) {
        int [] arr = new int[]{0,1,2,3,4,5,6,7,9};
        int i = missingNumber(arr);
        System.out.println(i);
    }
    public static int missingNumber(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count != nums[i]){
                break;
            }
            count++;
        }
        return count;
    }
}
