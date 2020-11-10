package year2020.day1109;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 复杂链表的复制
 */
public class New25 {
    public static void main(String[] args) {

    }

    public RandomListNode Clone(RandomListNode pHead) {
        LinkedHashMap<RandomListNode, RandomListNode> map = new LinkedHashMap<>();
        RandomListNode temp = pHead;
        while (temp != null) {
            RandomListNode node = new RandomListNode(temp.val);
            map.put(temp, node);//从1 开始记录
            temp = temp.next;
        }
        temp = pHead;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(pHead);
    }
}

// Definition for a Node.
class RandomListNode {
    int val;
    RandomListNode next, random;

    public RandomListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}