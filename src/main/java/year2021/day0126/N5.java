package year2021.day0126;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class N5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()) return stack2.pop();
        while (!stack1.isEmpty()){//将stack1的元素全部送到stack2中
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
