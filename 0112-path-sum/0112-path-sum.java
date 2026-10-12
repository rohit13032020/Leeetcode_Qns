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
    private boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        helper(root,0,targetSum);
        return ans; 
    }
    private void helper(TreeNode root,int Current_Sum,int targetSum) {
        if(root == null) {
            return;
        }
        Current_Sum += root.val;

        // check leaf node 
        if(root.left == null && root.right == null) {
            if(Current_Sum == targetSum) {
                ans = true;
            }
            return;
        }
        // call recursion fun for left and right
        helper(root.right,Current_Sum,targetSum);
        helper(root.left,Current_Sum,targetSum);
    }
}