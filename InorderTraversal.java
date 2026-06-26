// Binary Tree Inorder Traversal 

import java.util.ArrayList;
import java.util.List;


class Inorder {
    // common list that will be used to store the inordered nodes and returned later
    public List<Integer> inorder_nodes = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // reset the list for each top-level call
        inorder_nodes.clear();

        // perform recursive traversal using a helper
        traverse(root);
        return inorder_nodes;
    }

    // helper that actually performs recursion and appends to `inorder_nodes`
    private void traverse(TreeNode node) {
        if (node == null)
            return;
        traverse(node.left);
        inorder_nodes.add(node.val);
        traverse(node.right);
    }
}

public class InorderTraversal {
    public static void main(String[] args) {
        /*
         * Build the following tree
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 6
         */
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6)));

        Inorder solver = new Inorder();
        List<Integer> result = solver.inorderTraversal(root);
        System.out.println("Inorder traversal: " + result);
    }
}
