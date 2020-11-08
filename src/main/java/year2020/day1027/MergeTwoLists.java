package year2020.day1027;

import year2020.common.ListNode;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);head.next = l1;
        ListNode l2 = new ListNode(3);l1.next = l2;
        ListNode l3 = new ListNode(4);l2.next = l3;l3.next=null;

        ListNode head2 = new ListNode(5);
        ListNode l12 = new ListNode(6);head2.next = l12;
        ListNode l22 = new ListNode(7);l12.next = l22;l22.next=null;
        mergeTwoLists(head, head2);
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 示例1
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null ) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(-1);//新链表的头部
        ListNode tail = head;//新链表的尾部
        ListNode first = l1;//第一条链表
        ListNode second = l2;//第二条链表
        while (first != null && second != null) {
            if(first.val <= second.val){
                tail.next = first;
                tail = first;
                first = first.next;
            }else {
                tail.next = second;
                tail = second;
                second = second.next;
            }
        }
        if(first != null){
            tail.next = first;
        }
        if(second != null){
            tail.next = second;
        }
        return head.next;
    }

}
