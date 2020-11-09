package year2020.day1105;

import java.util.Stack;

public class StackMin {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {//入栈
       //入栈记录 栈顶
        stack.add(node);
        if(minStack.isEmpty() || minStack.peek() >= node) minStack.add(node);
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek())) minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
