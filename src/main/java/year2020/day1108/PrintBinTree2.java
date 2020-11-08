package year2020.day1108;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *          8
 *         /  \
 *        6    11
 *      /  \  / \
 *     4   7 10  12
 *    / \   /
 *  3   5  9
 *  [8],[6,11],[4,7,10,12],[3,5,9]]
 */
public class PrintBinTree2 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        ArrayList<ArrayList<Integer>> print = Print(treeNode);
        for (ArrayList<Integer> integers : print) {
            for (Integer integer : integers) {
                System.out.print(integer+"->");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(pRoot.val);
        queue.add(pRoot);//加入队列
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i >0; i--) {//这里有一个技巧，因为queue.size()是变化的，所以在初始化的时候
                TreeNode node = queue.poll();
                if(list.size() %2 == 0){//1 3 5 顺序
                    temp.add(node.val);
                }else {
                    temp.add(0,node.val);
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(temp);
        }
        return list;
    }
}
