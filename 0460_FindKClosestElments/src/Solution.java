public class Solution {
  public int[] kClosestNumbers(int[] A, int target, int k) {
    // write your code here
    int [] array = new int[k];

    int left = findLastPositionTarget(A, target);
    int right = left + 1;
    for(int i = 0; i < k; i++){
      if(isLeftCloser(left, right, A, target)){
        array[i] = A[left];
        left--;
      }
      else{
        array[i] = A[right];
        right++;
      }
    }
    return array;

  }
  boolean isLeftCloser(int left, int right, int A[], int target){
    if(left < 0){
      return false;
    }
    else if(right >= A.length){
      return true;
    }
    else if(target - A[left] > A[right] - target){
      return false;
    }
    else{
      return true;
    }
  }
  public int findLastPositionTarget(int A[], int target){
    int start = 0;
    int end = A.length - 1;
    int mid = 0;
    while(start + 1 < end){
      mid = start + (end - start) / 2;
      if(A[mid] == target){
        start = mid;
      }
      else if(A[mid] < target){
        start = mid;
      }
      else {
        end = mid;
      }
    }
    if(A[end] <= target){
      return end;
    }
    else if(A[start] <= target){
      return start;
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int [] A = {1,4,6,10,20};
    int k = 4;
    int []result = new int[k];
    result = sol.kClosestNumbers(A,21,k);
    for(int i = 0; i < k; i++){
      System.out.println(result[i] + " ");
    }
  }
}
