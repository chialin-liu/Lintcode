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
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     class resultType{
         public TreeNode node;
         public boolean aExist, bExist;
         resultType(boolean aExist, boolean bExist, TreeNode node){
             this.node = node;
             this.aExist = aExist;
             this.bExist = bExist;
         }
     }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null) return null;    
       resultType res = helper(root, A, B);
       return (res.aExist && res.bExist)? res.node: null;
        
    }
    public resultType helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null) return new resultType(false, false, root);
        resultType left = helper(root.left, A, B);
        resultType right = helper(root.right, A, B);
        
        boolean AExist = left.aExist || right.aExist || root == A;
        boolean BExist = left.bExist || right.bExist || root == B;
        if(root == A || root == B){
            return new resultType(AExist, BExist, root);
        }
        if(left.node != null && right.node != null) {
            return new resultType(AExist, BExist, root);
        }
        if(left.node != null){
            return new resultType(AExist, BExist, left.node);
        }
        if(right.node != null){
            return new resultType(AExist, BExist, right.node);
        }
        return new resultType(AExist, BExist, null);
    }
    
}
