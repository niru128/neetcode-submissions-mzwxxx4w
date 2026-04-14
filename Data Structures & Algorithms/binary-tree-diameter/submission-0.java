/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height , int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    TreeInfo diameter(TreeNode root){
        if(root == null){
            return new TreeInfo(0,0);
        }

        TreeInfo leftHeight = diameter(root.left);
        TreeInfo rightHeight = diameter(root.right);

        int myHeight = Math.max(leftHeight.height, rightHeight.height) + 1;

        int dia1 = leftHeight.diameter;
        int dia2 = rightHeight.diameter;

        int dia3 = leftHeight.height + rightHeight.height ;

        int d = Math.max(dia3, Math.max(dia1,dia2));

        return new TreeInfo(myHeight, d);
    }
    public int diameterOfBinaryTree(TreeNode root) {

        return diameter(root).diameter;
    }
}
