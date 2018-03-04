// Leetcode_102
// Binary Tree Level Order Traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        
        qu.add(root);
        while(!qu.isEmpty()) {
            int levelItems = qu.size();
            List<Integer> lst = new ArrayList<>();
            while(levelItems-- > 0) {
                TreeNode node = qu.poll();
                lst.add(node.val);
                
                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }
            result.add(lst);
        }
        
        return result;
    }
    
}