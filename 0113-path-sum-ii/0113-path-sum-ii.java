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
    private List<List<Integer>> result;

    private void solve(TreeNode root, int currentSum, int targetSum, List<Integer> path) {

        if (root == null) {
            return;
        }
        currentSum += root.val;
        path.add(root.val);

        // 2. Leaf node check
        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
 
                result.add(new ArrayList<>(path));
            }
            // Backtrack before returning from leaf
            path.remove(path.size() - 1);
            return;
        }

        solve(root.left, currentSum, targetSum, path);
        solve(root.right, currentSum, targetSum, path);

        // 4. Backtrack before returning from non-leaf node
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        solve(root, 0, targetSum, path);
        return result;
    }
}