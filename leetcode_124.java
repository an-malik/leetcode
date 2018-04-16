// Leetcode_124
// Binary Tree Maximum Path Sum
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
    
    int maxVal;
    
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        
        maxVal = Integer.MIN_VALUE;
        helper(root);
        return maxVal;
    }
    
    private int helper(TreeNode node) {
        // base case
        if(node == null) return 0;
        
        int lValue = Math.max(0, helper(node.left));
        int rValue = Math.max(0, helper(node.right));
        maxVal = Math.max(maxVal, lValue + rValue + node.val);
        return Math.max(lValue, rValue) + node.val;
    }
    
}
