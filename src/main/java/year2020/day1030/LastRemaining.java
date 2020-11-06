package year2020.day1030;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;
import year2020.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，[0]、1、[2]、3、[4]这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class LastRemaining {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        KthNode(treeNode, 2);
        System.out.println(result.val);
    }
    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        count = k;
        travelTree(pRoot);
        return result;
    }
    static private int count =0;
    static private TreeNode result = null;
    static void travelTree(TreeNode root){
        if(root == null || count <=0) return;
        travelTree(root.right);
        if(--count == 0) {
            result = root;
            return;
        }
        travelTree(root.left);
    }
    /**
     *          1
     *         / \
     *        2   3
     *      /  \ / \
     *     4   5 6  7
     *    / \   /
     *   8   9  10
     *
     */
}
