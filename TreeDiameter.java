// Find the diameter of a given binary tree

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Diameter {

    // variable to store the diameter
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Calling the helper function that finds the diameter, then returning it
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {

        // Base Case: if we hit null, return 0
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left); // Stores the length of the left subtree at curr pos
        int r = dfs(root.right); // Stores the length of the right subtree at curr pos

        diameter = Math.max(diameter, l + r); // Diammeter will be the maximum of either its current value, or the sum
                                              // of the right subtree length + left subtree length at the current pos

        return 1 + Math.max(l, r); // this adds 1 (for the edge it is going to travel) and moves on to the root
                                   // node by adding the 1 to the maximum value of the length of leftsubtree or the
                                   // right subtree
    }
}

public class TreeDiameter {
    public static void main(String[] args) {
        /*
         * Build the following tree:
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 6
         */
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6)));

        Diameter solver = new Diameter();
        int treeDiameter = solver.diameterOfBinaryTree(root);
        System.out.println("Diameter of tree: " + treeDiameter);
    }
}
