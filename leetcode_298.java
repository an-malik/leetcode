// Leetcode_298
// Binary Tree Longest Consecutive Sequence

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
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return helper(root, root.val, 0);
    }
    
    public int helper(TreeNode node, int prev, int count) {
        if(node == null) return count;
        
        if(node.val == prev + 1)
            count += 1;
        else
            count = 1;
        
        int lMax = helper(node.left, node.val, count);
        int rMax = helper(node.right, node.val, count);
        return Math.max(count, Math.max(lMax, rMax));
    }
}