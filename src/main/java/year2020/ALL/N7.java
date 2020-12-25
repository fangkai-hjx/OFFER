package year2020.ALL;

import Tree.common.TreeNode;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class N7 {
    public static void main(String[] args) {

    }

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        TreeNode recur = recur(0, 0, inorder.length-1);
        return recur;
    }

    public TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]);
        node.left = recur(root + 1, left, i - 1);
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;
    }

}
