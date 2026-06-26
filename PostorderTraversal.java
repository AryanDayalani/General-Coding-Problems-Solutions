// Binary Tree PostOrder Traversal 

import java.util.ArrayList;
import java.util.List;

class Postorder {
    public List<Integer> postorder_nodes = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        // Base Case - if we reach the end, then return empty list
        if (root == null) {
            return new ArrayList<>();
        }

        // The postordered function calling
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        postorder_nodes.add(root.val);

        return postorder_nodes;

    }
}

public class PostorderTraversal {
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

        Postorder solver = new Postorder();
        List<Integer> result = solver.postorderTraversal(root);
        System.out.println("Postorder traversal: " + result);
    }
}
