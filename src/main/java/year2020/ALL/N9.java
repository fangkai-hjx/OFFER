package year2020.ALL;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class N9 {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    //0 0
    //1 1
    //2 1
    //3 2
    //4 3
    static int constant = 1000000007;
    public static int fib(int n) {
        if(n <= 1) return n;
        int [] temps = new int[n+1];
        temps[0] = 0;
        temps[1] = 1;
        for (int i = 2; i <= n; i++) {
            temps[i] = (temps[i-1]%constant)+(temps[i-2]%constant);
        }
        return temps[n]%constant;
    }
}
