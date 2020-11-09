package Tree.digui1;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;
import sun.reflect.generics.tree.Tree;

/**
 * leetCode101 Symmetric Tree
 * 给出一颗二叉树，判断其是否左右对称
 *     1
 *   /   \
 *  2   2
 * / \ / \
 * 3  4 4  3
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return judge(root.left, root.right);

    }

    public static boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left != null && right==null) return false;
        else if (left == null && right!=null) return false;
        else if(left.val != right.val) return false;
        return judge(left.left,right.right) && judge(left.right,right.left);
    }
}
