package year2021;

import lombok.val;
import year2020.common.ListNode;
import year2020.common.ListNodeUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 链表的逆序
 */
public class NK03 {
    public static void main(String[] args) {
         ListNode listNodes = ListNodeUtils.createListNodes(1);
        final val integers = printListFromTailToHead(listNodes);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode == null) return result;
        ListNode temp = listNode;
        while (temp != null){
            result.add(0,temp.val);
            temp = temp.next;
        }
        return result;
    }
}
