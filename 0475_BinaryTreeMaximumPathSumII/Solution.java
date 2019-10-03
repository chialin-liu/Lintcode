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
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int maxPathSum2(TreeNode root) {
        // write your code here
        if(root == null) return 0;
        int ans = Integer.MIN_VALUE;
        Queue<NewNode> queue = new LinkedList<>();
        queue.offer(new NewNode(root, root.val));
        while(!queue.isEmpty()){
            NewNode cur = queue.poll();
            ans = Math.max(ans, cur.sum);
            if(cur.treenode.left != null) {
                queue.offer(new NewNode(cur.treenode.left, cur.sum + cur.treenode.left.val));
            }
            if(cur.treenode.right != null) {
                queue.offer(new NewNode(cur.treenode.right, cur.sum + cur.treenode.right.val));
            }
        }
        return ans;
    }
    public class NewNode{
        public TreeNode treenode;
        public int sum;
        public NewNode(TreeNode treenode, int sum){
            this.treenode = treenode;
            this.sum = sum;
        }
    }
}
