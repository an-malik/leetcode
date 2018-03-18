// Leetcode_108
// Convert Sorted Array to Binary Search Tree

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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int s, int e) {
        if (s > e) return null;
        
        int midIndex = (s + e) / 2;
        if((s + e) % 2 == 1) midIndex += 1;
        int midVal = nums[midIndex];
        
        TreeNode node = new TreeNode(midVal);
        node.left = helper(nums, s, midIndex - 1);
        node.right = helper(nums, midIndex + 1, e);
        
        return node;
    }
}