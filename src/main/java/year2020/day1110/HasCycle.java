package year2020.day1110;

import year2020.common.ListNode;

public class HasCycle {

    public static void main(String[] args) {

    }
    //第一种 方法：判断是否有环
    public boolean hasCycle(ListNode head) {
        if(head ==null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (slow  != null && fast!=null&&fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(slow == fast) return true;
        return false;
    }
    //第二种 方法：找出环的节点
}
