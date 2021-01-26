package year2021.day0126;

import year2020.common.ListNode;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 */
public class N3 {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null) return list;
        ListNode temp = listNode;
        while (temp != null){
            list.add(0,temp.val);
            temp = temp.next;
        }
        return list;
    }
}
