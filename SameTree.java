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
        // both null, then true
        if (p==null && q==null) {
            return true;
        }
        // if either of them null & other non-null, then false
        if (p!= null && q==null) {
            return false;
        }
        if (p==null && q!=null) {
            return false;
        }
        // if both have values, recursively check for each value
        if (p.val == q.val) {
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return (left && right);
        }
        // if both values not same, false
        return false;
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