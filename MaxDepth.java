// Finding the max depth of binary tree

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class DepthFinder {
    public int maxDepth(TreeNode root) {

        // Base Case
        if (root == null) {
            return 0;
        }

        // Find depths on both sides
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Add 1 to include root, and find the max depth on either sides
        return 1 + Math.max(leftDepth, rightDepth);
    }
}


public class MaxDepth {
    public static void main(String[] args) {
        DepthFinder df = new DepthFinder();

        // Creating a sample binary tree:
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        int depth = df.maxDepth(root);
        System.out.println("Maximum Depth of the Binary Tree: " + depth);
    }
}
