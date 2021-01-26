package year2021.day0126;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class N7 {
    public static void main(String[] args) {
        final N7 n7 = new N7();
        System.out.println(n7.JumpFloor(5));
    }
    //1 1
    //2 2
    //3 3
    //4 5
    public int JumpFloor(int target) {
        if(target <= 3) return target;
       int a = 1,b = 2, c = 3;
        for (int i = 3; i < target; i++) {
            a = b;
            b = c;
            c = a+b;
        }
        return c;
    }
}
