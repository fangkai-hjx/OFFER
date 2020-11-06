package year2020.day1102;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class KthLargest {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        ArrayList<ArrayList<Integer>> arrayLists = FindPath(treeNode, 20);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer+"->");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        if(root.left == null && root.right==null){//左子树为空 右子树 也为空
            if(root.val == target){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                result.add(list);
                return result;
            }
        }
        if(root.left != null){//左子树为空
            ArrayList<ArrayList<Integer>> leftResult = FindPath(root.left, target - root.val);
            if(leftResult != null && leftResult.size()>0){//返回结果类型
                for (int i = 0; i < leftResult.size(); i++) {
                    ArrayList<Integer> list = leftResult.get(i);
                    list.add(0,root.val);
                    result.add(list);
                }
            }
        }
        if(root.right != null){//右子树为空
            ArrayList<ArrayList<Integer>> rightResult = FindPath(root.right, target - root.val);
            if(rightResult != null && rightResult.size()>0){//返回结果类型
                for (int i = 0; i < rightResult.size(); i++) {
                    ArrayList<Integer> list = rightResult.get(i);
                    list.add(0,root.val);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
