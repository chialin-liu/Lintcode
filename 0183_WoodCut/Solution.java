public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int left = 1;
        int right = 0;
        for(int i = 0; i < L.length; i++){
            right = Math.max(L[i], right);
        }
        int res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(count(mid, L) >= k){
                res = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return  res;
    }
    public int count(int len, int [] L){
        int sum = 0;
        for(int i : L){
            sum += i / len;
        }
        return sum;
    }
}
