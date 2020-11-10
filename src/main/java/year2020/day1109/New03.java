package year2020.day1109;

import year2020.common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 示例1
 * 输入
 * 复制
 * {67,0,24,58}
 * 返回值
 * 复制
 * [58,24,0,67]
 */
public class New03 {
    public static void main(String[] args) {

    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null) return list;
        //使用栈
        Stack<Integer> stack = new Stack<>();
        ListNode node = listNode;
        //入栈
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        //出栈
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
