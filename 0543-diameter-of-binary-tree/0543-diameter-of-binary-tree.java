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
    int max_sum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Helper(root);
        return max_sum;
    }
    private int Helper(TreeNode root) {
        if(root == null) return 0;

        int left_sum = Helper(root.left);
        int right_sum = Helper(root.right);

        max_sum = Math.max(max_sum,left_sum+right_sum);

        return 1 + Math.max(left_sum,right_sum);
    }
}