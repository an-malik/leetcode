// Leetcode_173
// Binary Search Tree Iterator.
// Using Stack to traverse left children, parent and then right subtree.

// another way to solve this is using Morris Tree Traversal. IMP

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	private Stack<TreeNode> stk = new Stack<>();

    public BSTIterator(TreeNode root) {
    	pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode top = stk.pop();
    	pushLeft(top.right);
    	return top.val;
    }

    private void pushLeft(TreeNode node) {
    	
    	while(node != null) {
    		stk.push(node);
    		node = node.left;
    	}

    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */




