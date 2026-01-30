// Invert a Binary Tree

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
 
class Inverter {
    public TreeNode invertTree(TreeNode root) {
        // Base Case - if current node is null, return null.
        if (root == null) {
            return null;
        }

        // else, basic swap function
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively swap both sides of the tree
        invertTree(root.left);
        invertTree(root.right);
        
        return root;        
    }
}

public class InvertBinTree {
    public static void main(String[] args) {
        Inverter inverter = new Inverter();

        // Creating a sample binary tree:
        //       4
        //      / \
        //     2   7
        //    / \ / \
        //   1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        
        // Invert the binary tree
        TreeNode invertedRoot = inverter.invertTree(root);

        // Function to print the tree in-order (for verification)
        printInOrder(invertedRoot);
    }

    public static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}