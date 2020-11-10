package year2020.day1109;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 示例1
 * 输入
 * 1
 * 返回值
 * 1
 * <p>
 * 示例2
 * 输入
 * 4
 * 返回值
 * 5
 */
public class New08 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ":" + new New08().JumpFloor(i));
        }
    }

    public int JumpFloor(int target) {
        if (target <= 3) return target;
        int a = 1, b = 2, c =3;
        for (int i = 3; i < target; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
