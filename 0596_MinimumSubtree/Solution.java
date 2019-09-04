/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public int sum;
    public TreeNode subtree;
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        sum = Integer.MAX_VALUE;
        subtree = null;
        helper(root);
        return subtree;
    }
    public int helper(TreeNode root){
        if(root == null)return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int result_sum = root.val + left + right;
        if(subtree == null || result_sum < sum){
            sum = result_sum;
            subtree = root;
        }
        return result_sum;
    }
}
