package year2020.day1109;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 示例1
 * 输入
 * 3
 * 返回值
 * 4
 */
public class New09 {
    public static void main(String[] args) {
        New09 new09 = new New09();
        System.out.println(3 + ":" + new09.JumpFloorII(3));
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ":" + new09.JumpFloorII(i));
        }
    }

    // f(n) = f(n-1)+f(n-2)+f(n-3)+...f(2)+f(1);
    int[] memory;

    public int JumpFloorII(int target) {
        if (target <= 2) return target;
        memory = new int[target + 1];
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 2;
        for (int i = 3; i <= target; i++) {
            memory[i] = GetSum(i);
        }
        return memory[target];
    }

    private int GetSum(int i) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += memory[j];
        }
        return sum+1;
    }
}
