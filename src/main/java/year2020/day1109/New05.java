package year2020.day1109;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class New05 {
    Stack<Integer> stack1 = new Stack<Integer>();//这个用来 存放 数据
    Stack<Integer> stack2 = new Stack<Integer>();//这个用来 pop数据

    //入栈
    public void push(int node) {
        stack1.push(node);
    }

    //出栈
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        New05 new05 = new New05();
        new05.push(1);
        new05.push(2);
        new05.push(3);
        System.out.println("出栈：" + new05.pop());
        new05.push(4);
        System.out.println("出栈：" + new05.pop());
        System.out.println("出栈：" + new05.pop());
        System.out.println("出栈：" + new05.pop());
    }
}
