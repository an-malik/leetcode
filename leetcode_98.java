// Leetcode_98
// Validate binary search tree

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
    public boolean isValidBST(TreeNode root) {
        return recur(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean recur(TreeNode node, long minVal, long maxVal) {
        if(node == null) return true;
        if(node.val <= minVal || node.val >= maxVal)
            return false;
        return recur(node.left, minVal, node.val) && recur(node.right, node.val, maxVal);
    }
}