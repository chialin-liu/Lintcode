public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return new int []{-1,-1};
        }
        int left = findFirst(A, target);
        int right = findLast(A, target);
        int [] result = new int [2];
        result[0] = left;
        result[1] = right;
        return result;
    }
    public int findFirst(int [] A, int target){
        int start = 0;
        int end = A.length - 1;
        int mid ; 
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(A[mid] == target){
                end = mid;
            }
            else if(A[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(A[start] == target){
            return start;
        }
        else if(A[end] == target){
            return end;
        }
        return -1 ;
    }
    public int findLast(int [] A, int target){
        int start = 0;
        int end = A.length - 1;
        int mid ; 
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(A[mid] == target){
                start = mid;
            }
            else if(A[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(A[end] == target){
            return end;
        }
        else if(A[start] == target){
            return start;
        }
        return -1 ;
    }
}
