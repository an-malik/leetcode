// Leetcode_114
// Flatten Binary Tree to Linked List

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
     public void flatten(TreeNode n) { 
        n = helper(n);
     }
    public TreeNode helper(TreeNode n) {
        
        if(n == null) 
            return null;
        
        TreeNode l = helper(n.left);
        TreeNode r = helper(n.right);
        
        if(l == null)
            l = r;
        else {
            TreeNode itr = l;
            while(itr.right != null) {
                itr = itr.right;
            }
            itr.right = r;
        }
        
        n.left = null;
        n.right = l;
        
        return n;
    }
}
