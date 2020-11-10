package year2020.day1109;

/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class New11 {
    public static void main(String[] args) {

    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n == 0) {
            n = n & (n - 1);//这样可以去掉最低为的1
            count++;
        }
        return count;
    }
}
