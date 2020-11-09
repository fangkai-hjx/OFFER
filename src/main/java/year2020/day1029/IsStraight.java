package year2020.day1029;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: [0,0,0,2,5]
 * 输入: [0,1,2,4,5]
 * 输出: True
 *  
 * 限制：
 * <p>
 * 数组长度为 5 
 * <p>
 * 数组的数取值为 [0, 13] .
 */
public class IsStraight {
    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 2, 7};
        System.out.println(isStraight(ints));
    }

    //使用反证法了---排除不满足的就行了
    public static boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) {
            return false;
        }
        Arrays.sort(nums);
        int k = 0;//0,0,0,[2],7
        while (nums[k] == 0) k++;//k=3
        if ((nums[4] - nums[k]) > 4) return false;
        for (int i = k; i < nums.length - 1; i++) {
            if (nums[k] == nums[++k]) return false;
        }
        return true;
    }
}
