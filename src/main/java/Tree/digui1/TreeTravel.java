package Tree.digui1;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

public class TreeTravel {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();
        System.out.print("前序遍历:");
        preTravel(treeNode);
        System.out.println();
        System.out.print("中序遍历:");
        MidTravel(treeNode);
        System.out.println();
        System.out.print("后序遍历:");
        PostTravel(treeNode);
    }
    public static void preTravel(TreeNode treeNode){
        if(treeNode == null){
            return;
        }else {
            System.out.print(treeNode.val+"->");
        }
        preTravel(treeNode.left);
        preTravel(treeNode.right);
    }
    public static void MidTravel(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        MidTravel(treeNode.left);
        System.out.print(treeNode.val+"->");
        MidTravel(treeNode.right);
    }
    public static void PostTravel(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        PostTravel(treeNode.left);
        PostTravel(treeNode.right);
        System.out.print(treeNode.val+"->");
    }
}
