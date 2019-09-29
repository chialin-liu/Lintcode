public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        boolean []f = new boolean [n + 1];
        if(n == 0) return false;
        if(n == 1) return true;
        if(n == 2) return true;
        f[0] = false;
        f[1] = true;
        f[2] = true;
        for(int i = 3; i <= n; i++){
            f[i] = (f[i - 1] == false) || (f[i - 2] == false);
        }
        return f[n];
    }
}
