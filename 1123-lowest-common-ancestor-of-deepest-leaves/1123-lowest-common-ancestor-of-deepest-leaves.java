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
    private static class result{
        int depth;
        TreeNode node;

        result(int depth,TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
    private result dfs(TreeNode node) {
        if(node == null) {
            return new result(0,null);
        }
        result left = dfs(node.left);
        result right= dfs(node.right);

        if(left.depth == right.depth) {
            return new result(left.depth + 1,node);
        }

        if(left.depth > right.depth) {
           return new result(left.depth + 1,left.node);
        }
        return new result(right.depth+1,right.node);
    }
}