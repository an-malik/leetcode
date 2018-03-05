// Leetcode_94
// Binary tree in-order traversal 

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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;
        
        while(node != null || !stk.isEmpty()) {
            
            // really tricky with node != null to begin with in 
            // while condition above
            while(node != null) {
                stk.push(node);
                node = node.left;
            }
            
            node = stk.pop();
            result.add(node.val);
            node = node.right; 
            // needed. if this is null, 
            //it would simply be skipped in inner while loop 
        }
        
        return result;
    }
}