public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int []res = new int[A.length + B.length];
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        if(A == null && B == null) return res;
        while(indexA < A.length && indexB < B.length){
            if(A[indexA] < B[indexB]){
                res[indexC] = A[indexA];
                indexA++;
                indexC++;
            }
            else if(A[indexA] > B[indexB]){
                res[indexC] = B[indexB];
                indexB++;
                indexC++;
            }
            else{
                res[indexC] = A[indexA];
                indexC++;
                indexA++;
            }
        }
        while(indexA < A.length){
            res[indexC] = A[indexA];
            indexC++;
            indexA++;
        }
        while(indexB < B.length){
            res[indexC] = B[indexB];
            indexC++;
            indexB++;
        }
        return res;
    }
}
