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
    public int pathSum(TreeNode root, int target_sum) {
        if(root == null) return 0;

        return helper(root,(long) target_sum) + pathSum(root.left,target_sum) + pathSum(root.right,target_sum);
    }
    private int helper(TreeNode root,long target_sum) {
        if(root == null) return 0;
        int count = 0;

        if(target_sum == root.val) {
            count++;
        }
        count = count + helper(root.left,target_sum - root.val);
        count = count + helper(root.right,target_sum - root.val);
        return count;
    }
}