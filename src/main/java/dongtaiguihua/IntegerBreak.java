package dongtaiguihua;

import Tree.common.TreeNode;
import Tree.common.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 343
 *
 */
public class IntegerBreak {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.create();

        for (int i = 1; i <= 10; i++) {
            TreeNode node = KthNode(treeNode,i);
            System.out.println(node.val);
        }
    }
    static private int count =0;
    static private TreeNode result = null;
    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        count = k;
        travelTree(pRoot);
        return result;
    }
    static void travelTree(TreeNode root){
        if(root == null || count == 0) return;
        travelTree(root.right);
        if(--count == 0) {
            result = root;
            return;
        }
        travelTree(root.left);
    }
}
