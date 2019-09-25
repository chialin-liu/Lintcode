public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2) return 0;
        int cnt = 0;
        int sum = 0;
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while(left < right){
            sum = nums[left] + nums[right];
            if(sum > target){
                right--;
            }
            else{
                cnt = cnt + (right - left);
                left++;
            }
        }
        return cnt;
    }
}
