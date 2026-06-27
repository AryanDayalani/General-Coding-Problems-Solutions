// Flattening a given tree (pure recursion is more elegant, as attached in comments below. Implemnted approach is my intuition)

/* 

** Pure Recursion Elegant Approach

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Process right subtree first
        flatten(root.right);

        // Process left subtree
        flatten(root.left);

        // Set the current node's right to prev and left to null
        root.right = prev;
        root.left = null;

        // Update prev to current node
        prev = root;
    }
}

*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Flattener {
    public void flatten(TreeNode root) {

        // 1. Process the current node if it has a left child
        if (root != null && root.left != null) {
            TreeNode temp = root.right; // Save original right branch
            root.right = root.left; // Move left branch to the right
            root.left = null; // Disconnect the left side

            // 2. Find the bottom of the new right branch
            TreeNode tail = root.right;
            while (tail.right != null) {
                tail = tail.right;
            }

            // 3. Reattach the saved right branch to the bottom
            tail.right = temp;
        }

        // 4. Standard base case check
        if (root == null)
            return;

        // 5. Recursively flatten remaining subtrees
        flatten(root.left);
        flatten(root.right);
    }
}

public class FlattenTree {
    public static void main(String[] args) {
        /*
         * Build the following tree:
         * 1
         * / \
         * 2 5
         * / \ \
         * 3 4 6
         */
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));

        Flattener flattener = new Flattener();
        flattener.flatten(root);

        System.out.print("Flattened tree (right chain): ");
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val);
            if (current.right != null) {
                System.out.print(" -> ");
            }
            current = current.right;
        }
        System.out.println();
    }
}
