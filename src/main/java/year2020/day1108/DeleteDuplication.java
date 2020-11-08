package year2020.day1108;

import year2020.common.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);l1.next=l2;
        ListNode l3 = new ListNode(3);l2.next=l3;
        ListNode l4 = new ListNode(3);l3.next=l4;
        ListNode l5 = new ListNode(4);l4.next=l5;
        ListNode l6 = new ListNode(4);l5.next=l6;
        ListNode l7 = new ListNode(5);l6.next=l7;
        ListNode listNode = deleteDuplication(l1);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null) return pHead;//为空 或者 只有一个元素
        //使用三个指针
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode h1 = head;
        ListNode h2 = h1;
        ListNode h3 = head.next;
        while (h3 != null){
            if(h3.val == h2.val){
                while (h3 != null && h3.val == h2.val) h3 = h3.next;
                h1.next = h3;
                h2 = h1;
            }else {
                h1 = h2;
                h2 = h3;
                h3 = h3.next;
            }
        }
        return head.next;
    }
}
