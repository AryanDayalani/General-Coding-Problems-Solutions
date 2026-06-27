// Finding the Lowest common ancestor in the Binary Tree


// Intuition
// The idea is to traverse the tree and find the node where both `p` and `q`
// split into different subtrees. That node is the Lowest Common Ancestor.
// We use postorder traversal to return the LCA once both sides have non-null
// results.

// Approach
// - Base case: If `root` is `null`, return `null`.
// - If `root` is equal to either `p` or `q`, return `root`.
// - Recursively check left and right subtree.
// - If both return non-null, current node is the LCA.
// - If only one is non-null, propagate it upward.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class LCAFinder {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        // Easiest case - if root is null, no common ancestor
        if (root == null) return null;

        // if the root is either of our targets, then root itself is the LCA
        if (root == p || root == q) return root;


        // If not root, then we recursively ask both left and right if they have a target.
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        // If both have a target each, it means the split did happen at this level, so we return root as LCA
        if(l != null && r != null) return root;

        // if either of them has a target, we simply pass it up - we return only which side has a target and not the LCA.
        return l == null ? r : l;
    }
}

public class LCA {
    public static void main(String[] args) {
        /*
         * Build the following tree:
         * 3
         * / \
         * 5 1
         * / \ / \
         * 6 2 0 8
         * / \
         * 7 4
         */
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode root = new TreeNode(3, node5, node1);

        TreeNode p = node5;
        TreeNode q = node1;

        LCAFinder finder = new LCAFinder();
        TreeNode lca = finder.lowestCommonAncestor(root, p, q);

        System.out.println(
                "Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + (lca != null ? lca.val : "null"));
    }
}
