public class Solution {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int left = findFirst(A, target);
        int right = findLast(A, target);
        if((left == -1) && (right == -1)) return 0;
        return right - left + 1;
        
    }
    public int findFirst(int []A, int target){
        int start = 0;
        int end = A.length - 1;
        int mid;
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
    public int findLast(int []A, int target){
        int start = 0;
        int end = A.length - 1;
        int mid;
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
