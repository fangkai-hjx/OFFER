package year2020.day1109;

import Tree.common.TreeNode;

import java.util.HashMap;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 示例1
 * 输入
 * 复制
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 返回值
 * 复制
 * {1,2,5,3,4,6,7}
 */
public class New04 {

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] in = new int[]{3, 2, 4, 1, 6, 5, 7};
        New04.pre = pre;
        New04.in = in;
        TreeNode treeNode = new New04().reConstructBinaryTree(pre, in);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) return null;
        this.pre = pre;
        this.in = in;
        for (int i = 0; i < in.length; i++) {//建立hashmap表
            dic.put(in[i], i);
        }
        return build(0, 0, pre.length - 1);
    }

    static int[] pre;
    static int[] in;
    static HashMap<Integer, Integer> dic = new HashMap<>();

    private TreeNode build(int node, int left, int right) {
        //终止条件
        if (left > right) return null;
        //根据 root  划分 中序序列【左边】【右边】
        int div = dic.get(pre[node]);//得到第root 在 中序遍历的索引
        TreeNode root = new TreeNode(pre[node]);
        root.left = build(node + 1, left, div - 1);//建立左子树
        root.right = build(node + div - left + 1, div + 1, right);//建立右子树
        return root;
    }
}
