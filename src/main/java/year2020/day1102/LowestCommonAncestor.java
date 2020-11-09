package year2020.day1102;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先------好【【【【【【题
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        TreeNode treeNode1 = lowestCommonAncestor(treeNode, treeNode.left.left.right, treeNode.left.right);
        System.out.println(treeNode1.val);
    }
    //root 为 祖宗节点的条件 是 p 和 q 是 （1） root = p 或者 root = q （2）left
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null|| root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);//如果left的值不为null，表示p或者q的值在左边
        TreeNode right = lowestCommonAncestor(root.right,p,q);//如果right的值不为 null，表示p或者q的值在右边
        if(left == null && right == null) return null;//左右两边都没有
        if(left == null) return right;//p或者q 在左子树
        if(right == null) return left;//p或者q 在右子树
        return root;
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
}
