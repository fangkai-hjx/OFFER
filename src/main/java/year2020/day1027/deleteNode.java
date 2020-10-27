package year2020.day1027;

import year2020.common.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *[-3,5,-99]
 * -3
 */
public class deleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(-3);
        ListNode l1 = new ListNode(5);head.next = l1;
        ListNode l2 = new ListNode(-99);l1.next = l2;
        ListNode listNode = deleteNode(head, -3);
    }
    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if(head.val == val){
            return head.next;
        }
        ListNode p = head;
        ListNode q = p.next;
        while (q != null){
            if(q.val == val){//找到需要删除的节点
                p.next = q.next;
                break;
            }
            p = p.next;
            q = q.next;
        }
        return head;
    }
}
