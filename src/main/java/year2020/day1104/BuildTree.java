package year2020.day1104;

import Tree.common.TreeNode;
import year2020.common.ListNode;

import java.util.HashMap;

public class BuildTree {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);head.next = l1;
        ListNode l2 = new ListNode(3);l1.next = l2;
        ListNode l3 = new ListNode(4);l2.next = l3;l3.next=null;

        ListNode head2 = new ListNode(5);
        ListNode l12 = new ListNode(6);head2.next = l12;
        ListNode l22 = new ListNode(7);l12.next = l22;l22.next=null;
        ListNode merge = Merge(head, head2);
        while (merge!=null){
            System.out.print(merge.val+"->");
            merge = merge.next;
        }
    }

    static public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 != null && list2 == null) return list1;
        if(list1 == null && list2 != null) return list2;
        ListNode  first = list1;
        ListNode  second = list2;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (first != null && second != null){
            if(first.val < second.val){
                tail.next = first;
                tail = first;
                first = first.next;
            }else {
                tail.next = second;
                tail = second;
                second = second.next;
            }
        }
        if(first != null) tail.next = first;
        if(second != null) tail.next = second;
        return head.next;
    }
}
