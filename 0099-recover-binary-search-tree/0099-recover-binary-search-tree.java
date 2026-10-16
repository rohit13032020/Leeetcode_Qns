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
    private TreeNode first = null;
    private TreeNode middle = null;
    private TreeNode last = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // Fix 1: Pass 'root', not 'root.left'
        inOrder(root);

        // Case 1: Non-adjacent nodes swapped
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } 
        // Case 2: Adjacent nodes swapped (Fix 4: middle.val instead of last.val)
        else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    // Fix 2: Fixed method name typo 'Inroder' -> 'inOrder'
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        // Fix 5: Used '&&' instead of '&'
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root; // Fix 3: Variable name 'middle' matches declaration
            } else {
                last = root;
            }
        }

        prev = root;

        inOrder(root.right);
    }
}