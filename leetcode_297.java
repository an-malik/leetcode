// Leetcode_297
// Serialize and Deserialize Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializer(root, sb);
        return sb.toString();
    }
    private void serializer(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("X").append(",");
            return;
        }

        sb.append(node.val).append(",");
        serializer(node.left, sb);
        serializer(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(nodes));
        return deserializer(queue);
    }
    private TreeNode deserializer(Queue<String> data) {
        String val = data.poll();
        if(val.equals("X"))
            return null;

        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializer(data);
        node.right = deserializer(data);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
