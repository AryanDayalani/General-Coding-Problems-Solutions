// Checking whether the given binary tree is symmetric or not


// Defining a tree
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
 
class SymmetricFinder {

    // Function that calls the comparing function
    public boolean isSymmetric(TreeNode root) {

        // If root is null, directly return false
        if (root == null) {
            return false;
        }

        // call compare function and return the result
        return compare(root.left, root.right);

    }

    // Actual helper function that compares the tree and checks it for symmetry
    private boolean compare(TreeNode l, TreeNode r) {

        // both null means symmetry
        if (l == null && r == null) {
            return true;
        }

        // but either one null, means not symmetric
        else if (l == null || r == null) {
            return false;
        }

        // actual condition to check whether the tree has equal values and whether left subhalf == right subhalf (2 conditions)
        else {
            return (l.val == r.val && compare(l.left, r.right) && compare(l.right, r.left));
        }

    } 
}


public class SymmetricTree {
    public static void main(String[] args) {
        // Build a symmetric binary tree:
        //         1
        //       /   \
        //      2     2
        //     / \   / \
        //    3   4 4   3
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        SymmetricFinder finder = new SymmetricFinder();
        boolean result = finder.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);

        // Build a non-symmetric tree for demonstration
        TreeNode nonSymmetricRoot = new TreeNode(1,
            new TreeNode(2, null, new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(3))
        );

        boolean result2 = finder.isSymmetric(nonSymmetricRoot);
        System.out.println("Is the second tree symmetric? " + result2);
    }
    
}
