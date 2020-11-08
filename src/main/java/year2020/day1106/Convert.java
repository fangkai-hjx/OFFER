package year2020.day1106;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

/**
 * \题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        Convert(treeNode);
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        //对他进行中序遍历
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode left = Convert(pRootOfTree.left);
        pRootOfTree.left = left;
        TreeNode right = Convert(pRootOfTree.right);
        pRootOfTree.right = right;
        return pRootOfTree;
    }
}
