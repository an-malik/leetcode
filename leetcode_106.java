// Leetcode_106
// Create Binary tree given its in-order and post-order traversal

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
    
    class Index {
        int index;
    }
    
    public TreeNode buildTree(int[] in, int[] post) {
        
        int len = post.length;
        Index pIndex = new Index(len - 1);
        TreeNode tree = helper(in, post, 0, len - 1, pIndex);
        return tree;
    }
    
    private TreeNode helper(int[] in, int[] post, int s, int e, Index pIndex) {
        
        if(s > e)
            return null;
        
        int val = post[pIndex--];
        TreeNode node = new TreeNode(val);
        
        int pivot = search(in, val, s, e);
        
        node.left = helper(in, post, pivot + 1, e, pIndex);
        node.right = helper(in, post, s, pivot - 1, pIndex);
        
        return node;
    }
    
    private int search(int[] data, int val, int s, int e) {
        while(s <= e) {
            if(data[s] == val) break;
            s++;
        }
        
        return s;
    }
}