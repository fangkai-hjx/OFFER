package year2020.day1105;

import java.util.Stack;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 */
public class Power {
    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};
        int[] popA2 = new int[]{4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(pushA, popA));
        System.out.println(validateStackSequences(pushA, popA2));
    }

    //1  2  3  5
    //1, 2, 3, 4, 5
    //4, 5, 3, 2, 1
    public static boolean validateStackSequences(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int pushValue : pushA) {
            stack.push(pushValue);
            while (!stack.isEmpty() && stack.peek() == popA[i]) {
                i++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
