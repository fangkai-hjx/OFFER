package year2020.day1109;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * <p>
 * 示例1
 * 输入
 * 4
 * 返回值
 * 3
 */
public class New07 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("f("+i+")"+"="+new New07().Fibonacci(i));
        }
    }

    public int Fibonacci(int n) {
        if (n <= 1) return n;//f(0) = 0;f(1)=1;
        int a = 0, b = 1, c = 1;
        for (int i = 1; i < n-1; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
