public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0) return 0;
        int [][]f = new int [nums.length + 1][2];
        f[0][0] = 0;
        f[0][1] = 0;
        int t = 0;
        int n = nums.length;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 2; j++){
                f[i][j] = Integer.MAX_VALUE;
                t = 0;
                if(nums[i - 1] != j){
                    t = 1;
                }
                for(int k = 0; k < 2; k++){
                    if(k == 0 && j == 1) continue;
                    f[i][j] = Math.min(f[i][j], f[i - 1][k] + t);
                }
            }
        }
        return Math.min(f[n][0], f[n][1]);
    }
}
