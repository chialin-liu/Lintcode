public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        if(A == null || A.length == 0) return;
        for(int i = (A.length - 2) / 2; i >= 0; i--){
            shitDown(A, i);
        }
        return ;
    }
    public void shitDown(int []A, int k){
        int n = A.length;
        while(k < n){
            int left = k * 2 + 1;
            int right = left + 1;
            int minIdx = k;
            if(left < n && A[left] < A[minIdx]){
                minIdx = left;
            }
            if(right < n && A[right] < A[minIdx]){
                minIdx = right;
            }
            if(minIdx == k) break;
            int tmp = A[minIdx];
            A[minIdx] = A[k];
            A[k] = tmp;
            
            k = minIdx;
        }
    }
    
}
