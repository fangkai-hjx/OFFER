package Tree.common;

/**
 *          1
 *         / \
 *        2   3
 *      /  \ / \
 *     4   5 6  7
 *    / \   /
 *   8   9  10
 *
 */
public class TreeUtils {

    public static TreeNode create(){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1; root.right = r1;

        TreeNode l21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(5);
        TreeNode r21 = new TreeNode(6);
        TreeNode r22 = new TreeNode(7);
        l1.left = l21;l1.right = l22;
        r1.left = r21;r1.right = r22;
        TreeNode l31 = new TreeNode(8);
        TreeNode r31 = new TreeNode(9);
        TreeNode l32 = new TreeNode(10);
        l21.left =l31;l21.right=r31;
        l22.left=null;l22.right=null;
        r31.left=null;r31.right=null;
        l22.left=null;l22.right=null;
        r21.left=l32;r21.right=null;
        l32.left=null;l32.right=null;
        r22.left=null;r22.right=null;
        return root;
    }
}
