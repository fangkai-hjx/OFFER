package Tree.digui2;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于递归 也可以返回一些复杂的值
 * 257：给定一颗二叉树，返回所有表示从根节点到叶子节点路径的字符串
 */
public class TreePaths {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        String[] allTreePaths = getAllTreePaths(treeNode);
        for (String allTreePath : allTreePaths) {
            System.out.println(allTreePath);
        }
    }

    //终止条件：叶子节点直接放回其值的字符串
    // root-》{左子树的路径字符串}
    // root-》{右子树的路径字符串}
    public static String[] getAllTreePaths(TreeNode treeNode) {
        List<String> list = new ArrayList<>();
        if (treeNode == null) return null;
        if (treeNode.left == null && treeNode.right == null) {
            list.add(treeNode.val + "");
            return list.toArray(new String[list.size()]);
        }
        String[] leftPaths = getAllTreePaths(treeNode.left);
        if (leftPaths != null) {
            for (int i = 0; i < leftPaths.length; i++) {
                list.add(treeNode.val + "->" + leftPaths[i]);
            }
        }

        String[] rightPaths = getAllTreePaths(treeNode.right);
        if (rightPaths != null) {
            for (int i = 0; i < rightPaths.length; i++) {
                list.add(treeNode.val + "->" + rightPaths[i]);
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
