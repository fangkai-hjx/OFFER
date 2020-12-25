package year2020.ALL;

import year2020.common.ListNode;
import year2020.common.ListNodeUtils;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 */
public class N6 {
    public static void main(String[] args) {
        ListNode listNodes = ListNodeUtils.createListNodes(5);
        int[] ints = reversePrint2(listNodes);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
    public static int[] reversePrint(ListNode head) {
        if(head == null ) return null;
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }
        int[] ints = new int[stack.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop();
        }
        return ints;
    }
    public static int[] reversePrint2(ListNode head) {
        //先将链表逆序
        if(head == null )return new int[]{};
        if(head.next == null) return new int[]{head.val};
        ListNode font = head;
        ListNode back =font.next;
        font.next = null;
        ListNode temp;
        int size =1;
        while (back != null){
            temp = back.next;
            back.next = font;
            font = back;
            back = temp;
            size ++;
        }
        int[] array = new int[size];
        int i =0;
        while (font !=null){
            array[i++] = font.val;
            font = font.next;
        }
        return  array;
    }
}
