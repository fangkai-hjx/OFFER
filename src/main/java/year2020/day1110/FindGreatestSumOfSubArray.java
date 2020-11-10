package year2020.day1110;

public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] ints = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(ints));
    }
    //dp[i] 表示 到 a[i] 的连续子序列的 最大和，包含a[i]
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return -1;
        //动态规划
        //空间直接使用原数组
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i]+Math.max(array[i-1], 0);
            res = Math.max(array[i],res);
        }
        return res;
    }
}
