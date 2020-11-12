package year2020.day1109;

import year2020.common.ListNode;

//输入一个链表，输出该链表中倒数第k个结点。
//示例1
//输入
//1,{1,2,3,4,5}
//返回值
//{5}
public class New14 {
    public static void main(String[] args) {
        New14 new14 = new New14();
    }

    //第二种方法，双指针
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null) return head;
        ListNode p = head;
        ListNode q = head;
        //1,2,3,[4],5
        for (int i = 0; i < k - 1; i++) {
            p = p.next;
        }
        if(p == null) return null;//这里 表示 k 的 取值 不合法
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        return q;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return head;
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        p = head;
        int step = count - k + 1;
        while (p != null) {
            if (--step == 0) {
                return p;
            }
            p = p.next;
        }
        return p;
    }
}
