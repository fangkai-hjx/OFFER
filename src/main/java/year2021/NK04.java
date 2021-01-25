package year2021;

import Tree.common.TreeNode;
import lombok.val;

import java.util.HashMap;

//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class NK04 {
    public static void main(String[] args) {

        TreeNode treeNode = new NK04().reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
        System.out.println("dada");
    }

    int[] pre;
    int[] in;
    HashMap<Integer, Integer> dirc = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) return null;
        this.pre = pre;
        this.in = in;
        for (int i = 0; i <= in.length - 1; i++) {
            dirc.put(in[i], i);
        }
        return rebuildTree(0, 0, in.length - 1);
    }

    public TreeNode rebuildTree(int node, int left, int right) {
        if (left > right) return null;
        TreeNode treeNode = new TreeNode(pre[node]);
        Integer location = dirc.get(pre[node]);//位置
        treeNode.left = rebuildTree(node + 1, left, location - 1);
        treeNode.right = rebuildTree(node + location - left + 1, location + 1, right);
        return treeNode;
    }
}
