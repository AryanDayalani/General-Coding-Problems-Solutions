// Binary Tree Preorder Traversal 

import java.util.ArrayList;
import java.util.List;


class Preorder {
    public List<Integer> preorder_nodes = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        //Base Case - if we reach the end, then return empty list
        if(root == null) {
            return new ArrayList<>();
        }

        // The preordered function calling
        preorder_nodes.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return preorder_nodes;
        
    }
}

public class PreorderTraversal {
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

        Preorder solver = new Preorder();
        List<Integer> result = solver.preorderTraversal(root);
        System.out.println("Inorder traversal: " + result);
    }
}
