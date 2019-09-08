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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
     private List<Integer> list;
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here'
        list = new ArrayList<>();
        if(root == null) return list;
        helper(root, k1, k2);
        return list;
    }
    private void helper(TreeNode root, int k1, int k2){
        if(root == null) return ;
        if(root.val > k1){
            helper(root.left, k1, k2);
        }
        
        if(root.val < k2){
            helper(root.right, k1, k2);
        }
        if(root.val >= k1 && root.val <= k2){
            list.add(root.val);
        }
       
    }
}
