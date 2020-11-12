package byteDance.code2020;

import year2020.common.ListNode;
import year2020.common.ListNodeUtils;

public class ReverseList {
    public static void main(String[] args) {
        ListNode listNodes = ListNodeUtils.createListNodes(1);

        ListNode reverse = reverse(listNodes);
        while (reverse != null){
            System.out.print(reverse.val+"->");
            reverse = reverse.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode font = head;
        ListNode end = head.next;
        ListNode temp;
        font.next =null;
        while (end != null) {
            temp = end.next;//取出end 下一个 缓存起来
            end.next = font;//逆转指针 顺序
            //下一次准备
            font = end;
            end = temp;
        }
        return font;
    }
}
