// Checking if 2 trees are same

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

class SameTreeChecker {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // if both are empty trees, both are identical
        if (p == null && q == null) {
            return true;
        }

        // If only one of them is empty, can't be identical
        if (p == null || q == null) {
            return false;
        }

        boolean l = false;  // stores if leftsubtree of p == q
        boolean r = false;  // // stores if rightsubtree of p == q

        // if value of p and q are same, we recursively check at both the left and right subtrees of p & q
        if (p.val == q.val) {
            l = isSameTree(p.left, q.left);
            r = isSameTree(p.right, q.right);

        }

        // if both right and left subhalves identical, entire tree is identical
        if (l && r) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class SameTree{
    public static void main(String[] args) {
        SameTreeChecker checker = new SameTreeChecker();

        // Creating first sample binary tree:
        //       1
        //      / \
        //     2   3
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Creating second sample binary tree:
        //       1
        //      / \
        //     2   3
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean result = checker.isSameTree(p, q);
        System.out.println("Are the two trees identical? " + result);
    }
}