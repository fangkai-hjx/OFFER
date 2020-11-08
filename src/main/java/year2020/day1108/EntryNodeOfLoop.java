package year2020.day1108;

import year2020.common.ListNode;

import java.util.HashSet;

public class EntryNodeOfLoop {
    public static void main(String[] args) {

    }
    public  static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null) return pHead;
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp=pHead ;
        while (temp == null){
            if(!set.add(pHead)) return temp;
            temp = temp.next;
        }
        return null;
    }
}
