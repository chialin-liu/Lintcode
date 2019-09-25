public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        if(S == null || S.length == 0) return 0;
        int ans = 0;
        int left = 0;
        int right = 0;
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++){
            left = 0;
            right = i - 1;
            while(left < right){
                if(S[left] + S[right] > S[i]){
                    ans = ans + (right - left);
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return ans;
    }
}
