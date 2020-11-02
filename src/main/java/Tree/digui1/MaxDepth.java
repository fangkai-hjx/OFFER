package Tree.digui1;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;
import sun.reflect.generics.tree.Tree;

/**
 * 求二叉树的深度
 */
public class MaxDepth {
    public static void main(String[] args) {
//        TreeNode treeNode = TreeUtils.create();
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        treeNode.left = left;
        System.out.println("二叉树的深度为："+maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int leftDepth = maxDepth(treeNode.left);
        int rightDepth = maxDepth(treeNode.right);
        return (leftDepth >= rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }
}
