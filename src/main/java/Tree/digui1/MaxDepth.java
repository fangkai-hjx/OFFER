package Tree.digui1;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

/**
 * 求二叉树的深度
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        System.out.println("二叉树的深度为："+maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int leftDepth = maxDepth(treeNode.left);
        int rightDepth = maxDepth(treeNode.right);
        return (leftDepth >= rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }
}
