package Tree.digui1;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

/**
 * 110 判断一颗二叉树是否是平衡二叉树（每一个节点的左右子树的高度差不超过1）
 */
public class BalancedTree {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        System.out.println(isBalanced(treeNode));
    }
    static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(!isBalanced(root.left)) return false;//左子树不为平衡二叉树
        if(!isBalanced(root.right)) return false;//右子树不为平衡二叉树
        //左子树 和 右子树 都是 平衡二叉树，计算加上根节点
        if(Math.abs(getDepth(root.left)-getDepth(root.right))>1) return false;
        return true;
    }
    static int getDepth(TreeNode treeNode){
        if(treeNode == null) return 0;
        int leftDepth = getDepth(treeNode.left);
        int rightDepth = getDepth(treeNode.right);
        return (leftDepth>=rightDepth)?(leftDepth+1):(rightDepth+1);
    }
}
