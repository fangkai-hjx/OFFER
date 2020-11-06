package year2020.day1106;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

public class TreeToDoublyList {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        TreeNode treeNode1 = Convert(treeNode);
    }

    private static TreeNode pre, head;

    public static TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    //牛客网
    public  static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        dfs(pRootOfTree);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private static void dfs(TreeNode cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;//保存该节点
        dfs(cur.right);
    }
}
