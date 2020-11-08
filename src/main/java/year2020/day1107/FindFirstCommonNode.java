package year2020.day1107;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import year2020.common.ListNode;

public class FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode common1 = new ListNode(11);
        ListNode common2 = new ListNode(22);common1.next=common2;
        ListNode common3 = new ListNode(33);common2.next=common3;
        ListNode common4 = new ListNode(44);common3.next=common4;

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);l1.next=l2;
        l2.next = common1;

        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(4);r1.next=r2;
        ListNode r3 = new ListNode(6);r2.next=r3;
        r3.next=common2;
        System.out.println("链表1的节点值信息");
        ListNode start = l1;
        while (start!=null){
            System.out.print(start.val+"->");
            start = start.next;
        }
        System.out.println("链表1的节点值信息");
        start = r1;
        while (start!=null){
            System.out.print(start.val+"->");
            start = start.next;
        }
        System.out.println("-------------------------");
        System.out.println(FindFirstCommonNode(l1, r1).val);
    }
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        int n1 = 0,n2=0;
        ListNode s1=pHead1,s2=pHead2;
        while (s1!=null){
            n1++;
            s1 = s1.next;
        }
        System.out.println("链表1的长度"+n1);
        while (s2!=null){
            n2++;
            s2 = s2.next;
        }
        System.out.println("链表2的长度"+n2);
        //对齐
        s1=pHead1;
        s2=pHead2;
        int subLength = (n1-n2);
        if(subLength >0){//l1 长，l1先走 subLength 步数
            while (subLength>0){
                s1 =s1.next;
                subLength--;
            }
        }else {
            while (subLength>0){
                s2 =s2.next;
                subLength--;
            }
        }
        //开始比较
        while (s1 != null && s2 != null){
            if(s1 == s2) return s1;
            else {
                s1 = s1.next;
                s2 = s2.next;
            }
        }
        return null;
    }
}
