package year2020.day1030;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-8));//  11111111 11111111 11111111 11111000
    }
//    //// you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        //陷阱  step1：n & 1  step2 : n>>1  这样在负数的时候陷入死循环
//        int count = 0;
//        while (n != 0){
//            if((n & 1) == 1) count++;
//            n = n>>1;
//        }
//        return count;
//        ----------------------------------------------------------------
        //下面使用了技巧：n&(n-1)将 数字n 的 最右边的 1 变为 0
        int count = 0;
        while (n != 0){//直到把n变为0
            count ++ ;
            n = n & (n-1);
        }
        return count;
    }
}
