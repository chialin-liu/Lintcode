public class Solution {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(A == null){
            res.add(new ArrayList<>());
            return res;
        }
        helper(A, k, target, res, new ArrayList<>(), 0);
        return res;
    }
    private void helper(int []A, int k, int target, List<List<Integer>> res, List<Integer> list, int start){
        if((list.size() == k) && (target == 0)){
            res.add(new ArrayList<>(list));
            return;
        } 
        if(target < 0) return ;
        if(list.size() == k){
            return;
        }
        for(int i = start; i < A.length; i++ ){
            list.add(A[i]);
            helper(A, k, target - A[i], res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
