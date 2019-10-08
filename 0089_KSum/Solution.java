public class Solution {
    /**
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] A, int k, int target) {
        // write your code here
        int n = A.length;
        int [][][] dp = new int [n + 1][k + 1][target + 1];
        for(int i = 0; i <= k; i++){
            for(int j = 0; j <= target; j++){
                dp[0][i][j] = 0;
            }
        }
        dp[0][0][0] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= k; j++){
                for(int f = 0; f <= target; f++){
                    dp[i][j][f] = dp[i - 1][j][f];
                    if(j > 0 && f >= A[i - 1]){
                        dp[i][j][f] += dp[i - 1][j - 1][f - A[i - 1]];
                    }
                }
            }
        }
        return dp[n][k][target];
    }
}
