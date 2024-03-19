/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null) return 0;
        return getSum(root, 1, 1); //r, p, gp
    }

    private int getSum(TreeNode root, int p, int gp){
        if(root ==null) return 0;
        int sum = 0;
        if(gp%2==0) sum += root.val;

        int l = getSum(root.left, root.val, p);
        int r = getSum(root.right, root.val, p);

        return l+r+sum;
    }
}
