// Leetcode_110
// Balanced Binary Tree

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
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    
    private int height(TreeNode node) {
         
        if (node == null) return 0;
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        
        if(lHeight == -1 || rHeight == -1 || Math.abs(lHeight - rHeight) > 1) return -1;
        
        return (lHeight > rHeight ? lHeight : rHeight) + 1;
    }
}