package year2020.day1030;

/**
 剑指 Offer 53 - I. 在排序数组中查找数字 I
 统计一个数字在排序数组中出现的次数。

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: 2
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: 0


 限制：

 0 <= 数组长度 <= 50000
 */
public class Search {
    public static void main(String[] args) {
        int[] array = new int[]{5,7,7,8,8,10};
        int search = search(array, 6);
        System.out.println(search);
    }
    public static int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                count ++;
            }
        }
        return count;
    }
    //使用二分查找的思想
    //算法解析：
    //初始化： 左边界 i = 0i=0 ，右边界 j = len(nums) - 1j=len(nums)−1 。
    //循环二分： 当闭区间 [i, j][i,j] 无元素时跳出；
    //计算中点 m = (i + j) / 2m=(i+j)/2 （向下取整）；
    //若 nums[m] < targetnums[m]<target ，则 targettarget 在闭区间 [m + 1, j][m+1,j] 中，因此执行 i = m + 1i=m+1；
    //若 nums[m] > targetnums[m]>target ，则 targettarget 在闭区间 [i, m - 1][i,m−1] 中，因此执行 j = m - 1j=m−1；
    //若 nums[m] = targetnums[m]=target ，则右边界 rightright 在闭区间 [m+1, j][m+1,j] 中；左边界 leftleft 在闭区间 [i, m-1][i,m−1] 中。因此分为以下两种情况：
    //若查找 右边界 rightright ，则执行 i = m + 1i=m+1 ；（跳出时 ii 指向右边界）
    //若查找 左边界 leftleft ，则执行 j = m - 1j=m−1 ；（跳出时 jj 指向左边界）
    //返回值： 应用两次二分，分别查找 rightright 和 leftleft ，最终返回 right - left - 1right−left−1 即可。
    //效率优化：
    //以下优化基于：查找完右边界 right = iright=i 后，则 nums[j]nums[j] 指向最右边的 targettarget （若存在）。
    //
    //查找完右边界后，可用 nums[j] = jnums[j]=j 判断数组中是否包含 targettarget ，若不包含则直接提前返回 00 ，无需后续查找左边界。
    //查找完右边界后，左边界 leftleft 一定在闭区间 [0, j][0,j] 中，因此直接从此区间开始二分查找即可。
    //
    //6 / 6
    //
    //复杂度分析：
    //时间复杂度 O(log N)O(logN) ： 二分法为对数级别复杂度。
    //空间复杂度 O(1)O(1) ： 几个变量使用常数大小的额外空间。
    //代码：
    public static int search2(int[] nums, int target) {
        return 1;
    }
}
