package year2021.day0126;

import Tree.common.TreeNode;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class N4 {
    public HashMap<Integer, Integer> dict = new HashMap<>();
    public int[] pre;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) return null;
        this.pre = pre;
        for (int i = 0; i < in.length; i++) {
            dict.put(in[i], i);
        }
        return reBuildBinaryTree(0, 0, in.length - 1);
    }

    public TreeNode reBuildBinaryTree(int k, int left, int right) {
        if (left > right) {
            return null;
        }
        final Integer index = dict.get(pre[k]);
        TreeNode treeNode = new TreeNode(pre[k]);
        treeNode.left = reBuildBinaryTree(k + 1, left, index - 1);
        treeNode.right = reBuildBinaryTree(k + index - left + 1, index + 1, right);
        return treeNode;
    }
}
