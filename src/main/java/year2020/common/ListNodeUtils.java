package year2020.common;

public class ListNodeUtils {

    public static ListNode createListNodes(int i){
            ListNode head = new ListNode(i);
            ListNode l1 = new ListNode(i+1);head.next = l1;
            ListNode l2 = new ListNode(i+2);l1.next = l2;
            ListNode l3 = new ListNode(i+3);l2.next = l3;
            ListNode l4 = new ListNode(i+4);l3.next = l4;l4.next=null;
            return head;
    }
}
