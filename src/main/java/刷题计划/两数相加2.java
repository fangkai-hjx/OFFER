package 刷题计划;

import year2020.common.ListNode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以0开头。
 * <p>
 * <p>
 * 示例 1：
 * 2——————>4------->3
 * 4------>6------->4
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class 两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        int next = 0, v;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null || l2 != null) {
            v = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + next;
            tail.next = new ListNode(v % 10); // 18 %10 =8  18/10 = 1
            tail = tail.next;
            next = v / 10;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        if (next != 0) {
            tail.next = new ListNode(next);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        l2.next = l4;
        ListNode l3 = new ListNode(3);
        l4.next = l3;
        l3.next = null;
        printListNode(l2);
        ListNode r5 = new ListNode(5);
        ListNode r6 = new ListNode(6);
        r5.next = r6;
        ListNode r4 = new ListNode(4);
        r6.next = r4;
        r4.next = null;
        printListNode(r5);
        ListNode listNode = new 两数相加2().addTwoNumbers(l2, r5);
        printListNode(listNode);
    }

    public static void printListNode(ListNode list) {
        while (list != null) {
            System.out.print(list.val+" ");
            list = list.next;
        }
        System.out.println();
    }
}
