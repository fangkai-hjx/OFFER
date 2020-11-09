package year2020.day1104;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        int[] ints = levelOrder(treeNode);
        for (int anInt : ints) {
            System.out.println(anInt + "->");
        }
    }

    static public int[] levelOrder(final TreeNode root) {
        if(root == null) return  new int[0];
            //开队列
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            result.add(treeNode.val);
            if(treeNode.left!=null) queue.add(treeNode.left);
            if(treeNode.right!=null) queue.add(treeNode.right);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
