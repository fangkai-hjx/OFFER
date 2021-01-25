package year2020.ALL;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class N10 {

    // f(n) = f(n-1) + f(n-2)
    // 0 1
    // 1 1
    // 2 2
    public int numWays(int n) {
        if(n ==0) return 1;
        if(n<=2) return n;
        int[] temps = new int[n + 1];
        temps[0] =1;
        temps[1] =1;
        for (int i = 2; i <= n; i++) {
            temps[i] = temps[i-1]%1000000007 + temps[i-2]%1000000007;
        }
        return temps[n]%1000000007;
    }
}
