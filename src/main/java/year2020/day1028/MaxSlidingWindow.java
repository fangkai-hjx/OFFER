package year2020.day1028;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints1 = maxSlidingWindow(ints,3);
        for (int i = 0; i < ints1.length; i++) {
            System.out.print(ints1[i]+"->");
        }
        //[3,3,5,5,6,7]
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        //n-k+1
        int[] result = new int[nums.length - k + 1];
        int i = 0, j = i + k - 1;
        for (int start = 0; start < result.length; start++) {
            int max = nums[start];
            for (int s = start; s < start + k; s++) {
                if(nums[s]>max){
                    max = nums[s];
                }
            }
            result[start] = max;
        }
        return result;
    }
}
