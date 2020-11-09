package year2020.day1102;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 */
public class KthLargest {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        System.out.println(KthNode(treeNode, 1).val);
    }
//    static int count, value ;
//    public static int kthLargest(TreeNode root, int k) {
//        count = k;
//        postTravel(root);
//        return value;
//    }
//    public static void postTravel(TreeNode treeNode){
//        if(treeNode == null) return;
//        postTravel(treeNode.right);
//        if(--count == 0){
//            value = treeNode.val;
//            return;
//        }
//        postTravel(treeNode.left);
//
//    }
    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        count = k;
        travelTree(pRoot);
        return result;
    }
    private static int count =0;
    private static TreeNode result = null;
    static void travelTree(TreeNode root){
        if(root == null || count <=0) return;
        travelTree(root.left);
        if(--count == 0) {
            result = root;
            return;
        }
        travelTree(root.right);
    }
}
