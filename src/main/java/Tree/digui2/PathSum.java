package Tree.digui2;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               [5]
 *              / \
 *            [4]  [8]
 *            /   / \
 *          [11]  13  [4]
 *          /  \    / \
 *         7   [2] [5]   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        List<List<Integer>> lists = pathSum(treeNode, 20);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return null;
        if(root.left == null && root.right == null) {
            List<Integer> numList = new ArrayList<>();
            numList.add(root.val);
            result.add(numList);
            return result;
        }
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        if(left != null && left.size() > 0){
            for (int i = 0; i < left.size(); i++) {
                List<Integer> leftNode = left.get(i);
                leftNode.add(root.val);
                result.add(leftNode);
            }
        }
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        if(right != null && right.size() > 0){
            for (int i = 0; i < right.size(); i++) {
                List<Integer> rightNode = right.get(i);
                rightNode.add(root.val);
                result.add(rightNode);
            }
        }
        return result;
    }
}
