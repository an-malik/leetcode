// Leetcode_285
// Inorder Successor in BST

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(p.right != null) {
            p = p.right;
            while(p.left != null) p = p.left;
            return p;
        }

        TreeNode temp = root;
        TreeNode succ = null;
        while(temp != p) {
            if(p.val < temp.val) {
                succ = temp;
                temp = temp.left;
            } else
                temp = temp.right;
        }

        return succ;
    }
}
