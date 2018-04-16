// Leetcode_236
// Lowest Common Ancestor of a Binary Tree

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null || node == p || node == q)
            return node;

        TreeNode l = helper(node.left, p, q);
        TreeNode r = helper(node.right, p, q);

        if(l != null && r != null)
            return node;

        if(r == null)
            return l;
        else
            return r;
    }
}
