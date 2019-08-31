public class Solution {
    /**
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(A[mid] == target){
                return mid;
            }
            else if(A[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(target - A[start] < A[end] - target){
            return start;
        }else{
            return end;
        }
    }
}
