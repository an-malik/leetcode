// Leetcode_101
// Symmetric binary tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return root == null || helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null || right == null) {
            return left == right;
        }
        boolean ans = left.val == right.val;
        return ans && helper(left.left, right.right) && helper(left.right, right.left);
    }
}