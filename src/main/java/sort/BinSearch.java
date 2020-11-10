package sort;

import java.util.Arrays;

/**
 * 二分查找---》完美
 * https://blog.csdn.net/ageovb/article/details/106011237?utm_medium=distribute.pc_relevant.none-task-blog-title-2&spm=1001.2101.3001.4242
 */
public class BinSearch {
    private static int[] array;
    private static int target;

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 4, 4, 4, 4, 4, 5};
        System.out.println(binarySearch2_floor(nums, 4));
        System.out.println(binarySearch2_ceil(nums, 4));
    }

    public static int binarySearch2_floor(int[] nums, int target) {

        // 特殊用例判断
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        // 在 [left, right] 区间里查找 target
        int left = 0;
        int right = len - 1;
        while (left < right) {
            // 选择中间位置时下取整
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                // [left, mid]都小于目标值，下一轮查找区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 此时：nums[mid] >= target
                // [mid, right]都大于等于目标值，下一轮查找区间是 [left, mid]
                right = mid;
            }
        }

        // 退出循环的时候 left == right，程序只剩下一个元素没有看到。
        // 视情况，是否需要单独判断 left（或者 right）这个下标的元素是否符合题意。
        return nums[left] == target ? left : -1;
    }
    public static int binarySearch2_ceil(int[] nums, int target) {

        // 特殊用例判断
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        // 在 [left, right] 区间里查找 target
        int left = 0;
        int right = len - 1;
        while (left < right) {
            // 选择中间位置时上取整
            int mid = left + (right - left + 1) / 2;

            if (nums[mid] > target) {
                // [mid, right]都大于目标值，下一轮查找区间是 [left, mid - 1]
                right = mid - 1;
            } else {
                // nums[mid] <= target
                // [left, mid]都小于等于目标值，下一轮查找区间是 [mid, right]
                left = mid;
            }
        }

        // 退出循环的时候 left == right，程序只剩下一个元素没有看到。
        // 视情况，是否需要单独判断 left（或者 right）这个下标的元素是否符合题意。
        return nums[left] == target ? left : -1;
    }

}
