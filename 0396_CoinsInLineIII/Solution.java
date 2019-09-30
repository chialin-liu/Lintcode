public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0) return true;
        int n = values.length;
        int [][] f = new int [n][n];
        for(int i = 0; i < n; i++){
            f[i][i] = values[i];
        }
        
        for(int len = 2; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                f[i][j] = Math.max(values[i] - f[i + 1][j], values[j] - f[i][j - 1]);
            }
        }
        return f[0][n - 1] > 0;
    }
}
