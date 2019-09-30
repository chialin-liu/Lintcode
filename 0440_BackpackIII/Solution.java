public class Solution {
    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        int [][] f = new int[n + 1][m + 1];
        f[0][0] = 0;
        for(int i = 1; i <= m; i++){
            f[0][i] = -1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                f[i][j] = f[i - 1][j];
                
                if(j >= A[i - 1] && f[i][j - A[i - 1]] != -1){
                    f[i][j] = Math.max(f[i][j], f[i][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= m; i++){
            res = Math.max(res, f[n][i]);
        }
        return res;        
    }
}
