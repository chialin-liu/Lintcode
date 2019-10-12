public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
        double left = 0;
        double right = Math.max(1, x);
        while(left <= right){
            double mid = (right - left) / 2 + left;
            if(mid * mid == x) return mid;
            else if(mid * mid > x) right = mid - 0.0000000001;
            else left = mid + 0.0000000001;
        }
        return right;
        
    }
    
}
