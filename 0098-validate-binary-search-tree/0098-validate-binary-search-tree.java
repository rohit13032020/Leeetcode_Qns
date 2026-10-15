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
    private TreeNode prev = null;
    private boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        isValid = true;
        Inorder(root);
        return isValid;

    }
    private void Inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        Inorder(root.left);

        if(prev == null){
            prev = root;
        } else {
               if(root.val <= prev.val) {
               isValid = false;
               }
               prev = root;
        }
        Inorder(root.right);

    }
}