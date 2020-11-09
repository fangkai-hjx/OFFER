package Tree.digui1;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

/**
 * leetcode226 反转一颗二叉树，镜像
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.create();
        TreeNode treeNode = invertTree(root);
        TreeTravel.preTravel(treeNode);
    }
    public static TreeNode invertTree(TreeNode root){
        if(root == null){//不需要操作
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
