package year2021.day0126;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n\leq 39n≤39
 */
public class N6 {
    public static void main(String[] args) {
        final N6 n6 = new N6();
        System.out.println(n6.Fibonacci(5));
    }
    public int Fibonacci(int n) {
//        f[0] = 0
//        f[1] = 1
//        f[2] = 1
//        f[3] = 2
//        f[4] = 3
//        f[5] = 5
        if(n <=1) return n;
        int a = 0,b=1,c=1;
        for (int i = 2; i < n; i++) {
            a = b;
            b = c;
            c = a+b;
        }
        return c;
    }
}
