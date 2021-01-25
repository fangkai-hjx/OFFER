package year2020.ALL;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 *
 */
public class N8 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public N8() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    //队列尾部插入整数
    public void appendTail(int value) {
        s1.add(value);
    }
    //在队列头部删除整数
    public int deleteHead() {
        if(!s2.isEmpty()) return s2.pop();
        if (s1.isEmpty()) return -1;
        while (s1.empty()){
            s2.add(s1.pop());
        }
        return s2.pop();
    }
}
