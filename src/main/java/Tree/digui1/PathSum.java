package Tree.digui1;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

/**
 * 112 给出一棵二叉树以及一个数字sum，判断在这颗二叉树上是否存在一条从
 * 根到叶子的路径，其路径上的所有节点和为sum。
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.create();
        System.out.println(hasPathSum(root, 5));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if (root.left == null && root.right == null) {
            System.out.println(root.val);
            return sum == root.val; // 叶子节点
        }
        if (hasPathSum(root.left, sum - root.val)) return true;
        if (hasPathSum(root.right, sum - root.val)) return true;
        return false;
    }
}
