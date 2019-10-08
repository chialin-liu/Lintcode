public class Solution {
    /**
     * @param n: the max identifier of planet.
     * @param m: gold coins that Sven has.
     * @param limit: the max difference.
     * @param cost: the number of gold coins that reaching the planet j through the portal costs.
     * @return: return the number of ways he can reach the planet n through the portal.
     */
    public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        // 
        long [][] dp = new long [n + 1][m + 1];
        for(int i = 0; i < m; i++){
            dp[0][i] = 0;
        }
        dp[0][m] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = 0;
                for(int k = i - limit; k < i; k++){
                    if(k < 0)continue;
                    if(j + cost[i] > m) continue;
                    dp[i][j] += dp[k][j + cost[i]];
                }
            }
        }
        long res = 0;
        for(int i = 0; i <= m; i++){
            res += dp[n][i];
        }
        return res;
    }
}
