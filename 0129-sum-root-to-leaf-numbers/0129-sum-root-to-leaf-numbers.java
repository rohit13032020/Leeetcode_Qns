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
    
    public int sumNumbers(TreeNode root) {
        return Helper(root,0);
    }
    private int Helper(TreeNode root,int Curr_Sum) {
        if(root == null) return 0;
        int sum = root.val;
        Curr_Sum = Curr_Sum * 10 + sum;
        if(root.left == null && root.right == null) {
            return Curr_Sum;
        }
        return Helper(root.left,Curr_Sum) + Helper(root.right,Curr_Sum);
    }
}