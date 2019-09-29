public class Solution {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        int [][]f = new int [n + 1][target + 1];
        f[0][0] = 1;
        for(int i = 1; i <= target; i++){
            f[0][i] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= target; j++){
                f[i][j] = f[i - 1][j];
                
                if(j >= A[i - 1]){
                    f[i][j] = f[i][j] + f[i - 1][j - A[i - 1]];
                }
            }
        }
        return f[n][target];
    }
}
